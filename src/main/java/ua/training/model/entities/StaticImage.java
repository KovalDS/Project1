package ua.training.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaticImage implements Image {
    private int id;
    private int size;
    private Tag tag;
    private LocalDate dateOfCreation;

    private List<SlideShow> slideShows;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Tag getTag() {
        return tag;
    }

    @Override
    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Override
    public String toString() {
        return "StaticImage{" +
                "size=" + size +
                ", tag=" + tag +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }


}
