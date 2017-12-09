package ua.training.model.entities;

import java.time.LocalDate;
import java.util.List;

public class AnimatedImage implements Image {
    private  int id;
    private int size;
    private Tag tag;
    private LocalDate dateOfCreation;
    private int length;

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

    public int getLength() {
        return length;
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

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "AnimatedImage{" +
                "size=" + size +
                ", tag=" + tag +
                ", dateOfCreation=" + dateOfCreation +
                ", length=" + length +
                '}';
    }
}
