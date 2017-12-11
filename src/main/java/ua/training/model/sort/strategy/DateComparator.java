package ua.training.model.sort.strategy;

import ua.training.model.entities.Image;

import java.util.Comparator;

public class DateComparator implements Comparator<Image> {

    @Override
    public int compare(Image o1, Image o2) {
        return o1.getDateOfCreation().compareTo(o2.getDateOfCreation());
    }
}
