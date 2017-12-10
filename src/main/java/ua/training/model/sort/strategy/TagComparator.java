package ua.training.model.sort.strategy;

import ua.training.model.entities.Image;

import java.util.Comparator;

public class TagComparator implements Comparator<Image> {

    @Override
    public int compare(Image o1, Image o2) {
        String tag1 = o1.getTag().name();
        String tag2 = o2.getTag().name();
        return tag1.compareTo(tag2);
    }
}
