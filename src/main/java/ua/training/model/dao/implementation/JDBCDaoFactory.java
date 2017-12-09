package ua.training.model.dao.implementation;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ImageDao;
import ua.training.model.dao.SlideShowDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public ImageDao createImageDao() {
        return new JDBCImageDao(getConnection());
    }

    @Override
    public SlideShowDao createSlideShowDao() {
        return new JDBCSlideShowDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/project1_seconddb?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "toor");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
