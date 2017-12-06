package ua.training.model;

import ua.training.model.dao.ImageDao;
import ua.training.model.entities.AnimatedSlide;
import ua.training.model.entities.Image;
import ua.training.model.entities.Slide;
import ua.training.model.entities.StaticSlide;
import ua.training.model.search.strategies.SearchStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SlideShowModel {
    private List<Slide> slideShow;
    private ImageDao imageDao;
    private Iterator<Slide> slideShowIterator;
    private Comparator<Slide> comparator;
    private SearchStrategy searchStrategy;

    public SlideShowModel(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    public void createSlideShow() {
        List<Image> images = imageDao.getAllImages();
        List<Slide> slides = new ArrayList<>();

        for (Image img : images) {
            if (img.getClass().getName().equals("AnimatedImage")) {
                AnimatedSlide slide = new AnimatedSlide();
                slide.setImage(img);
                slides.add(slide);
            } else {
                StaticSlide slide = new StaticSlide();
                slide.setImage(img);
                slides.add(slide);
            }
        }
        slideShow = slides;
        slideShowIterator = slides.iterator();
    }

    public Image nextSlide() {
        return slideShowIterator.next().showImage();
    }

    public boolean hasNextSlide() {
        if (slideShowIterator.hasNext()) {
            return true;
        } else {
            slideShowIterator = slideShow.iterator();
            return false;
        }
    }

    public int getTotalSize() {
        int totalSize = 0;
        while (slideShowIterator.hasNext()) {
            totalSize += slideShowIterator.next().showImage().getSize();
        }
        slideShowIterator = slideShow.iterator();
        return totalSize;
    }

    public void sortSlides() {
        slideShow.sort(comparator);
        slideShowIterator = slideShow.iterator();
    }

    public List<Slide> findSlides() {
        return searchStrategy.findSlides(slideShow);

    }

    public void setSlideShow(List<Slide> slideShow) {
        this.slideShow = slideShow;
        slideShowIterator = slideShow.iterator();
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void setComparator(Comparator<Slide> comparator) {
        this.comparator = comparator;
    }
}
