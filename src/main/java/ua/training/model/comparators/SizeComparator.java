package ua.training.model.comparators;

import ua.training.model.entities.Slide;

import java.util.Comparator;

public class SizeComparator implements Comparator<Slide> {

    @Override
    public int compare(Slide o1, Slide o2) {
        Integer size1 = o1.showImage().getSize();
        Integer size2 = o2.showImage().getSize();
        return size1.compareTo(size2);
    }
}
