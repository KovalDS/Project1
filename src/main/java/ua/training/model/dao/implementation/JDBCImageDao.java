package ua.training.model.dao.implementation;

import ua.training.model.dao.ImageDao;
import ua.training.model.entities.AnimatedImage;
import ua.training.model.entities.Image;
import ua.training.model.entities.StaticImage;
import ua.training.model.entities.Tag;
import ua.training.model.entities.builder.ImageBuilder;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JDBCImageDao implements ImageDao {
    private static final String GET_ALL_IMAGES = "SELECT * FROM image";
    private static final String GET_BY_ID = "SELECT * FROM image WHERE idimage = (?)";
    private static final String GET_BETWEEN_SIZE = "SELECT * FROM image WHERE image.size BETWEEN (?) AND (?)";
    private static final String GET_BETWEEN_DATE = "SELECT * FROM image WHERE image.date_of_creation BETWEEN (?) AND (?)";
    private static final String GET_BY_TAG = "SELECT * FROM image WHERE image.tag = (?)";

    private Connection connection;

    JDBCImageDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Image> getAllImages() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_IMAGES);
            return extractImageList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Image findById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return extractFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Image> getBetweenSize(int minSize, int maxSize) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BETWEEN_SIZE)) {
            preparedStatement.setInt(1, minSize);
            preparedStatement.setInt(2,maxSize);
            ResultSet resultSet = preparedStatement.executeQuery();
            return extractImageList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Image> getBetweenDate(LocalDate firstDate, LocalDate secondDate) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BETWEEN_DATE)) {
            preparedStatement.setDate(1, Date.valueOf(firstDate));
            preparedStatement.setDate(2,Date.valueOf(secondDate));
            ResultSet resultSet = preparedStatement.executeQuery();

            return extractImageList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Image> getByTag(Tag tag) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_TAG)) {
            preparedStatement.setString(1, tag.name());
            ResultSet resultSet = preparedStatement.executeQuery();
            return extractImageList(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Image extractFromResultSet(ResultSet queryResult) throws SQLException {

        if (queryResult.getBoolean("is_static")) {
            return new ImageBuilder()
                    .buildId(queryResult.getInt("idimage"))
                    .buildSize(queryResult.getInt("size"))
                    .buildDateOfCreation(queryResult.getDate("date_of_creation").toLocalDate())
                    .buildTag(Tag.valueOf(queryResult.getString("tag")))
                    .buildStaticImage();
        } else {
            return new ImageBuilder()
                    .buildId(queryResult.getInt("idimage"))
                    .buildSize(queryResult.getInt("size"))
                    .buildDateOfCreation(queryResult.getDate("date_of_creation").toLocalDate())
                    .buildTag(Tag.valueOf(queryResult.getString("tag")))
                    .buildlength(queryResult.getInt("length"))
                    .buildAnimatedImage();
        }
    }

    private List<Image> extractImageList(ResultSet resultSet) throws SQLException {
        List<Image> images = new ArrayList<>();
        while (resultSet.next()) {
            Image image = extractFromResultSet(resultSet);
            images.add(image);
        }
        return images;
    }
}
