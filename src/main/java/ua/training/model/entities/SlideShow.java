package ua.training.model.entities;

import java.util.ArrayList;
import java.util.List;

public class SlideShow {
    private int id;
    private String name;

    private List<Image> images = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getHash() {
        return System.identityHashCode(this);
    }
}
