package ua.training.model.dao.implementation;

import ua.training.model.dao.ImageDao;
import ua.training.model.entities.AnimatedImage;
import ua.training.model.entities.Image;
import ua.training.model.entities.StaticImage;
import ua.training.model.entities.Tag;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCImageDao implements ImageDao {
    private static final String GET_ALL_IMAGES = "SELECT * FROM images";
    private Connection connection;

    JDBCImageDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Image> getAllImages() {
        List<Image> images = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet queryResult = statement.executeQuery(GET_ALL_IMAGES);
            while (queryResult.next()) {
                Image image = extractFormResultSet(queryResult);
                images.add(image);
            }
            return images;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private Image extractFormResultSet(ResultSet queryResult) throws SQLException {
        if (queryResult.getBoolean("is_static")) {
            StaticImage image = new StaticImage();
            image.setSize(queryResult.getInt("size"));
            image.setDateOfCreation(queryResult.getDate("date_of_creation").toLocalDate());
            image.setTag(Tag.valueOf(queryResult.getString("tag")));
            return image;
        } else {
            AnimatedImage image = new AnimatedImage();
            image.setSize(queryResult.getInt("size"));
            image.setDateOfCreation(queryResult.getDate("date_of_creation").toLocalDate());
            image.setTag(Tag.valueOf(queryResult.getString("tag")));
            image.setLength(queryResult.getInt("length"));
            return image;
        }
    }

    @Override
    public List<Image> getImagesBeetwenDate() {
        return null;
    }

    @Override
    public List<Image> getImagesByTag() {
        return null;
    }

    @Override
    public List<Image> getImagesBeetwenSize() {
        return null;
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
}
