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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    public int getLength() {
        return length;
    }

    @Override
    public int getHash() {
        return System.identityHashCode(this);
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnimatedImage{" +
                "getHash=" + System.identityHashCode(this) +
                "size=" + size +
                ", tag=" + tag +
                ", dateOfCreation=" + dateOfCreation +
                ", length=" + length +
                '}';
    }
}
