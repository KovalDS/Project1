package ua.training.model.search.strategies;

import ua.training.model.entities.Slide;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FindBetweenDate implements SearchStrategy {
    private LocalDate firstDate;
    private LocalDate secondDate;

    public FindBetweenDate(LocalDate firstDate, LocalDate secondDate) {
        this.firstDate = firstDate;
        this.secondDate = secondDate;
    }

    @Override
    public List<Slide> findSlides(List<Slide> slides) {
        List<Slide> result = new ArrayList<>();

        for (Slide slide: slides) {
            if (UtilityMethods.isBetweenDate(firstDate, secondDate, slide.showImage().getDateOfCreation())) {
                result.add(slide);
            }
        }
        return result;
    }
}
