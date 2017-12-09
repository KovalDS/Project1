package ua.training.model.dao.implementation;

import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.SlideShow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCSlideShowDao implements SlideShowDao {
    private Connection connection;

    JDBCSlideShowDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<SlideShow> getAllSlideShows() {
        String query = "SELECT * FROM slide_show";
        List<SlideShow> resultList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                SlideShow slideShow = extractFromResultSet(resultSet);
                resultList.add(slideShow);
            }
            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSlideShow(SlideShow slideShow) {
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

    private static SlideShow extractFromResultSet(ResultSet resultSet) throws SQLException {
        SlideShow result = new SlideShow();

        result.setId(resultSet.getInt("idslide_show"));
        result.setName("name");

        return result;
    }
}
