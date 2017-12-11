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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getLength() {
        return 0;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StaticImage{" +
                "getHash=" + System.identityHashCode(this) +
                "size=" + size +
                ", tag=" + tag +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaticImage that = (StaticImage) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
