package ua.training.model.search.strategies;

import ua.training.model.entities.Tag;

import java.time.LocalDate;

class UtilityMethods {

     static boolean isBetweenDate(LocalDate firstDate, LocalDate secondDate, LocalDate dateOfCreation) {
        if (firstDate.compareTo(secondDate) > 0) {
            throw new RuntimeException("Wrong date input"); //TODO My own exception??
        }
        System.out.println(dateOfCreation.compareTo(firstDate) >= 0 && dateOfCreation.compareTo(secondDate) <= 0);
        return dateOfCreation.compareTo(firstDate) >= 0 && dateOfCreation.compareTo(secondDate) <= 0;
    }

    static boolean isBetweenSize(int lowerBound, int higherBound, int size) {
        if (lowerBound > higherBound) {
            throw new RuntimeException("Wrong date input"); //TODO My own exception??
        }
        return size >= lowerBound && size <= higherBound;
    }

    static boolean tagMatches(Tag tagToFind, Tag currentSlideTag) {
         return tagToFind.equals(currentSlideTag);
    }
}
