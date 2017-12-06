package ua.training.model.comparators;

import ua.training.model.entities.Slide;

import java.time.LocalDate;
import java.util.Comparator;

public class DateComparator implements Comparator<Slide>{

    @Override
    public int compare(Slide o1, Slide o2) {
        LocalDate date1 = o1.showImage().getDateOfCreation();
        LocalDate date2 = o2.showImage().getDateOfCreation();
        return date1.compareTo(date2);
    }
}
