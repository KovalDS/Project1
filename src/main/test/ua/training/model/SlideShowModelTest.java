package ua.training.model;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.comparators.DateComparator;
import ua.training.model.comparators.SizeComparator;
import ua.training.model.comparators.TagComparator;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SlideShowModelTest {
    private SlideShowModel slideShowModel;
    private List<Slide> slides = new ArrayList<>();

    @Before
    public void initialize() {
        slideShowModel = new SlideShowModel(DaoFactory.getInstance().createImageDao());
        slides = initSlideShow();
        slideShowModel.setSlideShow(initSlideShow());

    }

    @Test
    public void createSlideShow() throws Exception {

    }

    @Test
    public void nextSlide() throws Exception {
        for (int k = 0; k < 3; k++) {
            checkSlidesAreEqual();
        }
    }

    @Test
    public void hasNextSlide() throws Exception {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < slides.size(); i ++){
                assertEquals(slides.iterator().hasNext(), slideShowModel.hasNext());
            }
        }
    }

    @Test
    public void getTotalSize() throws Exception {
        int totalSize = slideShowModel.getTotalSize();
        int expected = 0;
        for (Slide slide : slides) {
            expected += slide.showImage().getSize();
        }
        assertEquals(expected, totalSize);
    }

    @Test
    public void sortSlides() throws Exception {
        slides.sort((o1, o2) -> o1.showImage().getSize() - o2.showImage().getSize());
        slideShowModel.setComparator(new SizeComparator());
        slideShowModel.sortSlides();
        checkSlidesAreEqual();
        slides.sort((o1, o2) -> o1.showImage().getDateOfCreation().compareTo(o2.showImage().getDateOfCreation()));
        slideShowModel.setComparator(new DateComparator());
        slideShowModel.sortSlides();
        checkSlidesAreEqual();
        slides.sort((o1, o2) -> o1.showImage().getTag().toString().compareTo(o2.showImage().getTag().toString()));
        slideShowModel.setComparator(new TagComparator());
        slideShowModel.sortSlides();
        checkSlidesAreEqual();
    }

    @Test
    public void findSlides() throws Exception {
    }

    private List<Slide> initSlideShow() {
        List<Slide> sl = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StaticImage image = new StaticImage();
            image.setTag(Tag.valueOf("NATURE"));
            image.setDateOfCreation(LocalDate.parse("201" + i + "-01-01"));
            image.setSize(i + 5);
            StaticSlide slide = new StaticSlide();
            slide.setImage(image);
            sl.add(slide);
        }
        for (int i = 0; i < 5; i++) {
            AnimatedImage image = new AnimatedImage();
            image.setTag(Tag.valueOf("FOOD"));
            image.setDateOfCreation(LocalDate.parse("201" + (i + 2) + "-01-01"));
            image.setSize(i + 10);
            AnimatedSlide slide = new AnimatedSlide();
            slide.setImage(image);
            sl.add(slide);
        }
        for (int i = 0; i < 5; i++) {
            StaticImage image = new StaticImage();
            image.setTag(Tag.valueOf("FOOD"));
            image.setDateOfCreation(LocalDate.parse("201" + (i + 3) + "-01-01"));
            image.setSize(i);
            StaticSlide slide = new StaticSlide();
            slide.setImage(image);
            sl.add(slide);
        }
        return sl;
    }

    private void checkSlidesAreEqual() {
        int i = 0;
        while (slideShowModel.hasNext()) {
            assertEquals( slides.get(i).showImage(), slideShowModel.next());
            i++;
        }
    }
}