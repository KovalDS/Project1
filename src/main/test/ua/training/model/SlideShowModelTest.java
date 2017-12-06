package ua.training.model;

import org.junit.Before;
import org.junit.Test;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entities.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SlideShowModelTest {
    private SlideShowModel slideShowModel;
    private List<Slide> slides = new ArrayList<>();

    @Before
    public void initialize() {
        slideShowModel = new SlideShowModel(DaoFactory.getInstance().createImageDao());
        for (int i = 0; i < 5; i++) {
            StaticImage image = new StaticImage();
            image.setTag(Tag.valueOf("NATURE"));
            image.setDateOfCreation(LocalDate.parse("201" + i + "-01-01"));
            image.setSize(i + 5);
            StaticSlide slide = new StaticSlide();
            slide.setImage(image);
            slides.add(slide);
        }
        for (int i = 0; i < 5; i++) {
            AnimatedImage image = new AnimatedImage();
            image.setTag(Tag.valueOf("FOOD"));
            image.setDateOfCreation(LocalDate.parse("201" + (i + 2) + "-01-01"));
            image.setSize(i + 10);
            AnimatedSlide slide = new AnimatedSlide();
            slide.setImage(image);
            slides.add(slide);
        }
        for (int i = 0; i < 5; i++) {
            StaticImage image = new StaticImage();
            image.setTag(Tag.valueOf("FOOD"));
            image.setDateOfCreation(LocalDate.parse("201" + (i + 3) + "-01-01"));
            image.setSize(i);
            StaticSlide slide = new StaticSlide();
            slide.setImage(image);
            slides.add(slide);
        }
        slideShowModel.setSlideShow(slides);

    }


    @Test
    public void createSlideShow() throws Exception {

    }

    @Test
    public void nextSlide() throws Exception {
        for (int i = 0; i < slides.size(); i ++){
            assertEquals(slides.get(i).showImage(), slideShowModel.nextSlide());
        }
    }

    @Test
    public void hasNextSlide() throws Exception {
        for (int i = 0; i < slides.size(); i ++){
            assertEquals(slides.iterator().hasNext(), slideShowModel.hasNextSlide());
        }
    }

    @Test
    public void getTotalSize() throws Exception {
    }

    @Test
    public void sortSlides() throws Exception {
    }

    @Test
    public void findSlides() throws Exception {
    }



}