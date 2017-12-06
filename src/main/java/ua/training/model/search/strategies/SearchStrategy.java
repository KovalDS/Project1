package ua.training.model.search.strategies;

import ua.training.model.entities.Slide;

import java.util.List;

public interface SearchStrategy {
    List<Slide> findSlides(List<Slide> slides);
}
