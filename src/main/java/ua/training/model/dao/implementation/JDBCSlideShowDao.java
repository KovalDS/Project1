package ua.training.model.dao.implementation;

import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;

import java.sql.*;
import java.util.*;

public class JDBCSlideShowDao implements SlideShowDao {
    private static final String GET_ALL_SLIDE_SHOWS = "SELECT * FROM slide_show LEFT JOIN image_has_slide_show " +
                                                                "USING(idslide_show) LEFT JOIN image USING (idimage)";
    private static final String INSERT_INTO_SLIDE_SHOW = "INSERT INTO slide_show (name) VALUES (?)";
    private static final String INSERT_INTO_IMAGE_HAS_SLIDE_SHOW = "INSERT INTO image_has_slide_show " +
                                                                "(idimage, idslide_show) VALUES (?, ?)";
    private static final String GET_BY_ID = "SELECT * FROM slide_show LEFT JOIN image_has_slide_show " +
                                                                "USING(idslide_show) LEFT JOIN image " +
                                                                "USING (idimage) WHERE idslide_show = (?)";

    private Connection connection;

    JDBCSlideShowDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SlideShow> getAllSlideShows() {
        Set<SlideShow> result = new HashSet<>();
        Map<Integer, SlideShow> slideShowMap = new HashMap<>();
        Map<Integer, Image> imageMap = new HashMap<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_SLIDE_SHOWS);
            while (resultSet.next()) {
                SlideShow slideShow = extractFromResultSet(resultSet);
                Image image = JDBCImageDao.extractFromResultSet(resultSet);

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
    public void addSlideShow(SlideShow slideShow) { //TODO (Don't remember what is wrong here actually)
        int slideShowId = 0;

        List<Image> images = slideShow.getImages();

        try (PreparedStatement insertSlideShow = connection.prepareStatement(INSERT_INTO_SLIDE_SHOW,
                Statement.RETURN_GENERATED_KEYS);
                PreparedStatement insertImage = connection.prepareStatement(INSERT_INTO_IMAGE_HAS_SLIDE_SHOW)) {

            insertSlideShow.setString(1, slideShow.getName());
            insertSlideShow.executeUpdate();
            ResultSet resultSet = insertSlideShow.getGeneratedKeys();
            if (resultSet.next()) {
                slideShowId = resultSet.getInt(1);
            }
            for (Image image : images) {
                insertImage.setInt(1, image.getId());
                insertImage.setInt(2, slideShowId);
                insertImage.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SlideShow findById(int id) {
        SlideShow slideShow;
        Image image;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            slideShow = extractFromResultSet(resultSet);
            image = JDBCImageDao.extractFromResultSet(resultSet);
            slideShow.getImages().add(image);

            while (resultSet.next()) {
                image = JDBCImageDao.extractFromResultSet(resultSet);
                slideShow.getImages().add(image);
            }
            return slideShow;
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

    private static SlideShow extractFromResultSet(ResultSet resultSet) throws SQLException {
        SlideShow result = new SlideShow();

        result.setId(resultSet.getInt("idslide_show"));
        result.setName(resultSet.getString("name"));

        return result;
    }

    private static SlideShow makeUniqueSlideShow(Map<Integer, SlideShow> slideShowMap, SlideShow slideShow) {
        slideShowMap.putIfAbsent(slideShow.getId(), slideShow);
        return slideShowMap.get(slideShow.getId());
    }


    private static Image makeUniqueImage(Map<Integer, Image> imageMap, Image image) {
        imageMap.putIfAbsent(image.getId(), image);
        return imageMap.get(image.getId());
    }
}
