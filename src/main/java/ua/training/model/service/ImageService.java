package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ImageDao;
import ua.training.model.dao.implementation.JDBCImageDao;
import ua.training.model.entities.Image;

import java.util.List;

public class ImageService {
    public List<Image> findAllImages() {
        List<Image> list;

        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        list = imageDao.getAllImages();
        return list;
    }
}
