package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ImageDao;
import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;
import ua.training.model.entities.Tag;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlideShowService {
    public void createSlideShow(List<Image> images, String name) {
        SlideShow slideShow = new SlideShow();
        slideShow.setName(name);
        slideShow.setImages(images);

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        slideShowDao.addSlideShow(slideShow);
    }

    public List<SlideShow> getAllSlideShows() {
        List<SlideShow> slideShows;

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        slideShows = slideShowDao.getAllSlideShows();
        return slideShows;
    }

    public SlideShow getSlideShow(int id) {
        SlideShow slideShow = new SlideShow();

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        slideShow = slideShowDao.findById(id);
        return slideShow;
    }

    public SlideShow getSlideShowImagesBetweenSize(int id, int minSize, int maxSize) {
        SlideShow slideShow = new SlideShow();

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        slideShow = slideShowDao.findById(id);
        List<Image> images = imageDao.getBetweenSize(minSize, maxSize);
        images = slideShow.getImages().stream()
                .filter(images::contains)
                .collect(Collectors.toList());
        slideShow.setImages(images);
        return slideShow;
    }

    public SlideShow getSlideShowImagesBetweenDate(int id, LocalDate firstDate, LocalDate secondDate) {
        SlideShow slideShow = new SlideShow();

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        slideShow = slideShowDao.findById(id);
        List<Image> images = imageDao.getBetweenDate(firstDate, secondDate);
        images = slideShow.getImages().stream()
                .filter(images::contains)
                .collect(Collectors.toList());
        slideShow.setImages(images);
        return slideShow;
    }

    public SlideShow getSlideShowImagesByTag(int id, Tag tag) {
        SlideShow slideShow = new SlideShow();

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        slideShow = slideShowDao.findById(id);
        List<Image> images = imageDao.getByTag(tag);
        images = slideShow.getImages().stream()
                .filter(images::contains)
                .collect(Collectors.toList());
        slideShow.setImages(images);
        return slideShow;
    }

    public int getTotalSize(int id) {
        SlideShow slideShow;
        List<Image> images;
        int totalSize = 0;

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        slideShow = slideShowDao.findById(id);

        images = slideShow.getImages();
        for (Image image : images) {
            totalSize += image.getSize();
        }
        return totalSize;
    }
}
