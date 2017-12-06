package ua.training.model.comparators;

import ua.training.model.entities.Slide;

import java.util.Comparator;

public class TagComparator implements Comparator<Slide>{

    @Override
    public int compare(Slide o1, Slide o2) {
        String tag1 = o1.showImage().getTag().name();
        String tag2 = o2.showImage().getTag().name();
        return tag1.compareTo(tag2);
    }
}
