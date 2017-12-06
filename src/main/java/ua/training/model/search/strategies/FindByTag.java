package ua.training.model.search.strategies;

import ua.training.model.entities.Slide;
import ua.training.model.entities.Tag;

import java.util.ArrayList;
import java.util.List;

public class FindByTag implements SearchStrategy {
    private Tag tagToFind;

    public FindByTag(Tag tagToFind) {
        this.tagToFind = tagToFind;
    }

    @Override
    public List<Slide> findSlides(List<Slide> slides) {
        List<Slide> result = new ArrayList<>();

        for (Slide slide : slides) {
            if (UtilityMethods.tagMatches(tagToFind, slide.showImage().getTag())) {
                result.add(slide);
            }
        }

        return result;
    }
}
