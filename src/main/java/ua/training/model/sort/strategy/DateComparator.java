package ua.training.model.sort.strategy;

import ua.training.model.entities.Image;

import java.time.LocalDate;
import java.util.Comparator;

public class DateComparator implements Comparator<Image> {

    @Override
    public int compare(Image o1, Image o2) {
        LocalDate date1 = o1.getDateOfCreation();
        LocalDate date2 = o2.getDateOfCreation();
        return date1.compareTo(date2);
    }
}
