package ua.training.model.entities.builder;

import ua.training.model.entities.AnimatedImage;
import ua.training.model.entities.Image;
import ua.training.model.entities.StaticImage;
import ua.training.model.entities.Tag;

import java.time.LocalDate;

public class ImageBuilder {
    private  int id;
    private int size;
    private Tag tag;
    private LocalDate dateOfCreation;
    private int length = 0;

    public ImageBuilder buildId(int id) {
        this.id = id;
        return this;
    }

    public ImageBuilder buildSize(int size) {
        this.size = size;
        return this;
    }

    public ImageBuilder buildTag(Tag tag) {
        this.tag = tag;
        return this;
    }

    public ImageBuilder buildDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
        return this;
    }

    public ImageBuilder buildlength(int length) {
        this.length = length;
        return this;
    }

    public Image buildAnimatedImage() {
        AnimatedImage image = new AnimatedImage();
        image.setId(id);
        image.setSize(size);
        image.setTag(tag);
        image.setDateOfCreation(dateOfCreation);
        image.setLength(length);
        return image;
    }

    public Image buildStaticImage() {
        StaticImage image = new StaticImage();
        image.setId(id);
        image.setSize(size);
        image.setTag(tag);
        image.setDateOfCreation(dateOfCreation);
        return image;
    }
}
