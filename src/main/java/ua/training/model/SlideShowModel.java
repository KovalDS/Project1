package ua.training.model;

import ua.training.model.dao.ImageDao;
import ua.training.model.entities.AnimatedSlide;
import ua.training.model.entities.Image;
import ua.training.model.entities.Slide;
import ua.training.model.entities.StaticSlide;
import ua.training.model.search.strategies.SearchStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static ua.training.view.TextConstants.ANIMATED_IMAGE;

/**
 * This class provides interface for controller to interact
 * with images stored in database.
 */
public class SlideShowModel {
    private List<Slide> slideShow;
    private int currentSlide;
    private ImageDao imageDao;
    private Comparator<Slide> comparator;
    private SearchStrategy searchStrategy;

    public SlideShowModel(ImageDao imageDao) {
        this.imageDao = imageDao;
    }

    /**
     * Creates slide show from all images stored in database.
     * This slide show is stored in field slideShow
     */
    public void createSlideShow() {
        List<Image> images = imageDao.getAllImages();
        List<Slide> slides = new ArrayList<>();

        for (Image img : images) {
            if (img.getClass().getName().equals(ANIMATED_IMAGE)) {
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
    }

    /**
     * Checks whether slide show has next slide.
     * Sets field currentSlide = 0 if end of
     * presentation is reached
     * @return does presentation has next slide.
     */
    public boolean hasNext() {
        if (currentSlide >= slideShow.size()) {
            currentSlide = 0;
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns next image of the slide show.
     * @return next image
     */
    public Image next() {
        return slideShow.get(currentSlide++).showImage();
    }

    public int getTotalSize() {
        int totalSize = 0;
        while (this.hasNext()) {
            totalSize += this.next().getSize();
        }
        return totalSize;
    }

    /**
     * Sorts slides according to the chosen strategy.
     */
    public void sortSlides() {
        slideShow.sort(comparator);
    }

    /**
     * Finds slides in the presentation according
     * to the chosen strategy.
     * @return list of slides that matches parameters of search
     */
    public List<Slide> findSlides() {
        return searchStrategy.findSlides(slideShow);

    }

    public void setSlideShow(List<Slide> slideShow) {
        this.slideShow = slideShow;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void setComparator(Comparator<Slide> comparator) {
        this.comparator = comparator;
    }

}
