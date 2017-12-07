package ua.training.model.search.strategies;

import ua.training.model.entities.Tag;

import java.time.LocalDate;

import static ua.training.view.TextConstants.WRONG_DATE;
import static ua.training.view.TextConstants.WRONG_SIZE;

class UtilityMethods {

     static boolean isBetweenDate(LocalDate firstDate, LocalDate secondDate, LocalDate dateOfCreation) {
        if (firstDate.compareTo(secondDate) > 0) {
            throw new RuntimeException(WRONG_DATE); //TODO My own exception??
        }
        return dateOfCreation.compareTo(firstDate) >= 0 && dateOfCreation.compareTo(secondDate) <= 0;
    }

    static boolean isBetweenSize(int lowerBound, int higherBound, int size) {
        if (lowerBound > higherBound) {
            throw new RuntimeException(WRONG_SIZE); //TODO My own exception??
        }
        return size >= lowerBound && size <= higherBound;
    }

    static boolean tagMatches(Tag tagToFind, Tag currentSlideTag) {
         return tagToFind.equals(currentSlideTag);
    }
}
