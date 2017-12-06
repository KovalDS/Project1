package ua.training.controller;

import ua.training.model.SlideShowModel;
import ua.training.model.entities.Slide;
import ua.training.model.entities.Tag;
import ua.training.model.search.strategies.FindBetweenDate;
import ua.training.model.search.strategies.FindBetweenSize;
import ua.training.model.search.strategies.FindByTag;
import ua.training.view.View;

import java.time.LocalDate;
import java.util.List;

public class Controller {
    private SlideShowModel slideShowModel;
    private View view;

    public Controller(SlideShowModel model, View view) {
        this.slideShowModel = model;
        this.view = view;
    }

    public void processUser() {
        slideShowModel.createSlideShow();

        showPresentation();

        view.printMessage("Total size is: " + slideShowModel.getTotalSize());

        view.printMessage("\n\nsearch by tag: ");
        slideShowModel.setSearchStrategy(new FindByTag(Tag.valueOf("FOOD")));
        List<Slide> slides = slideShowModel.findSlides();
        slideShowModel.createSlideShow();
        slideShowModel.setSlideShow(slides);
        showPresentation();

        view.printMessage("\n\nsearch between size: ");
        slideShowModel.setSearchStrategy(new FindBetweenSize(1, 6));
        slides = slideShowModel.findSlides();
        slideShowModel.setSlideShow(slides);
        showPresentation();

        view.printMessage("\n\nsearch between date: ");
        slideShowModel.setSearchStrategy(new FindBetweenDate(LocalDate.parse("2016-01-01"), LocalDate.parse("2018-01-01")));
        slides = slideShowModel.findSlides();
        slideShowModel.setSlideShow(slides);
        showPresentation();
        view.printMessage("Total size is: " + slideShowModel.getTotalSize());


    }

    void showPresentation() {
        while (slideShowModel.hasNextSlide()) {
            view.printMessage(slideShowModel.nextSlide());

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
