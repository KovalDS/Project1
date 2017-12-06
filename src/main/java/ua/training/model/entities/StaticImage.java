package ua.training.model.entities;

import java.time.LocalDate;

public class StaticImage implements Image {
    private int size;
    private Tag tag;
    private LocalDate dateOfCreation;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaticImage that = (StaticImage) o;

        if (size != that.size) return false;
        if (tag != that.tag) return false;
        return dateOfCreation.equals(that.dateOfCreation);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + tag.hashCode();
        result = 31 * result + dateOfCreation.hashCode();
        return result;
    }
}
