package ua.training.model.dao;

import ua.training.model.entities.SlideShow;

import java.util.List;

public interface SlideShowDao extends AutoCloseable {
    List<SlideShow> getAllSlideShows();
    void addSlideShow(SlideShow slideShow);
    SlideShow findById(int id);
    void delete();
    void update();
}
