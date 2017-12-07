package ua.training.model.entities;

import java.time.LocalDate;

import static ua.training.view.TextConstants.*;

public class AnimatedImage implements Image {
    private int size;
    private Tag tag;
    private LocalDate dateOfCreation;
    private int length;

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
        return  ANIMATED_IMAGE_TO_STRING + "{" +
                SIZE + "= " + size + ", " +
                TAG + "= " + tag + ", " +
                DATE_OF_CREATEION + "= " + dateOfCreation + ", " +
                LENGTH + "= " + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimatedImage that = (AnimatedImage) o;

        if (size != that.size) return false;
        if (length != that.length) return false;
        if (tag != that.tag) return false;
        return dateOfCreation.equals(that.dateOfCreation);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + tag.hashCode();
        result = 31 * result + dateOfCreation.hashCode();
        result = 31 * result + length;
        return result;
    }
}
