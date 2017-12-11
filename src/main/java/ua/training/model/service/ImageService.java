package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ImageDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.Tag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ImageService {
    public List<Image> findAllImages() {
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        return imageDao.getAllImages();
    }

    public List<Image> findImagesWithId(String[] idArray) { //TODO typecast should be performed in controller
        List<Image> images = new ArrayList<>();

        ImageDao imageDao = DaoFactory.getInstance().createImageDao();

        for(String idStr : idArray) {
            images.add(imageDao.findById(Integer.parseInt(idStr)));
        }
        return images;
    }

    public List<Image> findBetweenSize(int minSize, int maxSize) {
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        return imageDao.getBetweenSize(minSize, maxSize);
    }

    public List<Image> findBetweenDate(LocalDate firstDate, LocalDate secondDate) {
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        return imageDao.getBetweenDate(firstDate, secondDate);
    }

    public List<Image> findByTag(Tag tag) {
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        return imageDao.getByTag(tag);
    }

    public List<Image> sortImages(List<Image> images, Comparator<Image> comparator) {
        images.sort(comparator);
        return images;
    }
}
