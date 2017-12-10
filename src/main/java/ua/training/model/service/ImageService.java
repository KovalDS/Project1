package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ImageDao;
import ua.training.model.entities.Image;

import java.util.ArrayList;
import java.util.List;

public class ImageService {
    public List<Image> findAllImages() {
        List<Image> images;

        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        images = imageDao.getAllImages();
        return images;
    }

    public List<Image> findImagesWithId(String[] idArray) { //TODO typecast should be performed in controller?
        List<Image> images = new ArrayList<>();
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();

        for(String idStr : idArray) {
            images.add(imageDao.findById(Integer.parseInt(idStr)));
        }
        return images;
    }
}
