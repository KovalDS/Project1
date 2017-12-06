package ua.training.model.search.strategies;

import ua.training.model.entities.Slide;

import java.util.ArrayList;
import java.util.List;

public class FindBetweenSize implements SearchStrategy {
    private int minSize;
    private int maxSize;

    public FindBetweenSize(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public List<Slide> findSlides(List<Slide> slides) {
        List<Slide> result = new ArrayList<>();

        for (Slide slide: slides) {
            if (UtilityMethods.isBetweenSize(minSize, maxSize, slide.showImage().getSize())) {
                result.add(slide);
            }
        }
        return result;
    }
}
