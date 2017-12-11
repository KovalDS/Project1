package ua.training.controller.command;

import ua.training.model.entities.Image;
import ua.training.model.entities.SlideShow;
import ua.training.model.entities.Tag;
import ua.training.model.service.ImageService;
import ua.training.model.service.SlideShowService;
import ua.training.model.sort.strategy.DateComparator;
import ua.training.model.sort.strategy.SizeComparator;
import ua.training.model.sort.strategy.TagComparator;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class UtilityMethods {
    /**
     * Finds images by criteria that user chose.
     * If none was chosen returns all images stored
     * in database.
     * @param httpServletRequest
     * @return List of images
     */
    static List<Image> findImages(HttpServletRequest httpServletRequest) {
        String findBy = httpServletRequest.getParameter("search");
        ImageService imageService = new ImageService();

        if ("Find between size".equals(findBy)) {
            int minSize = Integer.parseInt(httpServletRequest.getParameter("lower_bound"));
            int maxSize = Integer.parseInt(httpServletRequest.getParameter("higher_bound"));
            return imageService.findBetweenSize(minSize, maxSize);
        } else if ("Find between date".equals(findBy)){
            LocalDate firstDate = LocalDate.parse(httpServletRequest.getParameter("first_date"));
            LocalDate secondDate = LocalDate.parse(httpServletRequest.getParameter("second_date"));
            return imageService.findBetweenDate(firstDate, secondDate);
        } else if ("Find by tag".equals(findBy)) {
            try {
                Tag tag = Tag.valueOf(httpServletRequest.getParameter("tag"));
                return imageService.findByTag(tag);
            } catch (IllegalArgumentException e) {
                return new ArrayList<Image>();
            }
        } else {
            return imageService.findAllImages();
        }
    }

    /**
     * Finds images in slide show by criteria that user chose.
     * If none was chosen returns slide show that
     * contains all images.
     * @param httpServletRequest
     * @return List of images
     */
    static SlideShow findImagesInSlide(HttpServletRequest httpServletRequest) {
        String findBy = httpServletRequest.getParameter("search");
        String presentationIdStr = httpServletRequest.getParameter("presentation");
        int presentationId = Integer.parseInt(presentationIdStr);
        SlideShowService slideShowService = new SlideShowService();

        if ("Find between size".equals(findBy)) {
            int minSize = Integer.parseInt(httpServletRequest.getParameter("lower_bound"));
            int maxSize = Integer.parseInt(httpServletRequest.getParameter("higher_bound"));
            return slideShowService.getSlideShowImagesBetweenSize(presentationId, minSize, maxSize);
        } else if ("Find between date".equals(findBy)){
            LocalDate firstDate = LocalDate.parse(httpServletRequest.getParameter("first_date"));
            LocalDate secondDate = LocalDate.parse(httpServletRequest.getParameter("second_date"));
            return slideShowService.getSlideShowImagesBetweenDate(presentationId, firstDate, secondDate);
        } else if ("Find by tag".equals(findBy)) {
            try {
                Tag tag = Tag.valueOf(httpServletRequest.getParameter("tag"));
                return slideShowService.getSlideShowImagesByTag(Integer.parseInt(presentationIdStr), tag);
            } catch (IllegalArgumentException e) {
                SlideShow slideShow = slideShowService.getSlideShow(presentationId);
                slideShow.getImages().clear();
                return slideShow;
            }

        } else {
            return slideShowService.getSlideShow(Integer.parseInt(presentationIdStr));
        }
    }

    /**
     * Sorts images by by criteria that user chose.
     * If none was chosen returns unsorted list
     * @param httpServletRequest
     * @param images
     * @return List of images
     */
    static List<Image> sortImages(HttpServletRequest httpServletRequest, List<Image> images) {
        String sortType = httpServletRequest.getParameter("sort");

        if ("Sort by size".equals(sortType)) {
            images.sort(new SizeComparator());
        } else if ("Sort by date".equals(sortType)) {
            images.sort(new DateComparator());
        } else if ("Sort by tag".equals(sortType)) {
            images.sort(new TagComparator());
        }
        return images;
    }
}
