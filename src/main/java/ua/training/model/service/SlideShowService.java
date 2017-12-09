package ua.training.model.service;

import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.SlideShowDao;
import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SlideShowService {
    public void createSlideShow(HttpServletRequest httpServletRequest) {

    }

    public List<SlideShow> getAllSlideShows() {
        List<SlideShow> slideShows;

        SlideShowDao slideShowDao = DaoFactory.getInstance().createSlideShowDao();
        slideShows = slideShowDao.getAllSlideShows();
        return slideShows;
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
