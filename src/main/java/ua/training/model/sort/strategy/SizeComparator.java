package ua.training.model.sort.strategy;

import ua.training.model.entities.Image;

import java.util.Comparator;

public class SizeComparator implements Comparator<Image> {

    @Override
    public int compare(Image o1, Image o2) {
        Integer size1 = o1.getSize();
        Integer size2 = o2.getSize();
        return size1.compareTo(size2);
    }
}
