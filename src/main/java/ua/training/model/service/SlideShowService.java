package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;

import java.util.ArrayList;
import java.util.List;

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

    public int getTotalSize(int id) {
        SlideShow slideShow;
        List<Image> images = new ArrayList<>();
        int totalSize = 0;

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        slideShow = slideShowDao.findById(id);

        images = slideShow.getImages();
        for (Image image : images) {
            totalSize += image.getSize();
        }
        return totalSize;
    }

    public List<Image> getAllImages() {
        return null;
    }

    public List<Image> getAllImagesSorted() {
        return null;
    }

    public int getTotalSize() {
        return 0;
    }
}
