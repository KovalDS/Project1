package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ImageDao;
import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;
import ua.training.model.entities.Tag;

import java.time.LocalDate;
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
        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        return slideShowDao.getAllSlideShows();
    }

    public SlideShow getSlideShow(int id) {
        return getSlideShowById(id);
    }

    public SlideShow getSlideShowImagesBetweenSize(int id, int minSize, int maxSize) {
        SlideShow slideShow = getSlideShowById(id);

        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        List<Image> images = imageDao.getBetweenSize(minSize, maxSize);

        images = getIntersection(slideShow.getImages(), images);
        slideShow.setImages(images);
        return slideShow;
    }

    public SlideShow getSlideShowImagesBetweenDate(int id, LocalDate firstDate, LocalDate secondDate) {
        SlideShow slideShow = getSlideShowById(id);

        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        List<Image> images = imageDao.getBetweenDate(firstDate, secondDate);

        images = getIntersection(slideShow.getImages(), images);
        slideShow.setImages(images);
        return slideShow;
    }

    public SlideShow getSlideShowImagesByTag(int id, Tag tag) {
        SlideShow slideShow = getSlideShowById(id);

        ImageDao imageDao = DaoFactory.getInstance().createImageDao();
        List<Image> images = imageDao.getByTag(tag);

        images = getIntersection(slideShow.getImages(), images);
        slideShow.setImages(images);
        return slideShow;
    }

    public int getTotalSize(int id) {
        SlideShow slideShow = getSlideShowById(id);
        List<Image> images;
        int totalSize = 0;

        images = slideShow.getImages();
        for (Image image : images) {
            totalSize += image.getSize();
        }
        return totalSize;
    }

    private SlideShow getSlideShowById(int id) {
        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        return slideShowDao.findById(id);
    }

    private List<Image> getIntersection(List<Image> list1, List<Image> list2) {
        return list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }
}
