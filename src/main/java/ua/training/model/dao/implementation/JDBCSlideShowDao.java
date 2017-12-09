package ua.training.model.dao.implementation;

import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;

import java.sql.*;
import java.util.*;

public class JDBCSlideShowDao implements SlideShowDao {
    private Connection connection;

    JDBCSlideShowDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SlideShow> getAllSlideShows() {
        String query = "SELECT * FROM slide_show " +
                "LEFT JOIN image_has_slide_show " +
                "USING(idslide_show) " +
                "LEFT JOIN image " +
                "USING (idimage)";
        Set<SlideShow> result = new HashSet<>();
        Map<Integer, SlideShow> slideShowMap = new HashMap<>();
        Map<Integer, Image> imageMap = new HashMap<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                SlideShow slideShow = extractFromResultSet(resultSet);
                Image image = JDBCImageDao.extractFormResultSet(resultSet);

                slideShow = makeUniqueSlideShow(slideShowMap, slideShow);
                image = makeUniqueImage(imageMap, image);

                slideShow.getImages().add(image); //TODO add image to slide???
                result.add(slideShow);
            }
            return new ArrayList<>(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSlideShow(SlideShow slideShow) { //TODO
        String query = "INSERT INTO slide_show (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, slideShow.getName());
            preparedStatement.executeUpdate();
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
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static SlideShow extractFromResultSet(ResultSet resultSet) throws SQLException {
        SlideShow result = new SlideShow();

        result.setId(resultSet.getInt("idslide_show"));
        result.setName("name");

        return result;
    }

    static SlideShow makeUniqueSlideShow(Map<Integer, SlideShow> slideShowMap, SlideShow slideShow) {
        slideShowMap.putIfAbsent(slideShow.getId(), slideShow);
        return slideShowMap.get(slideShow.getId());
    }


    static Image makeUniqueImage(Map<Integer, Image> imageMap, Image image) {
        imageMap.putIfAbsent(image.getId(), image);
        return imageMap.get(image.getId());
    }
}
