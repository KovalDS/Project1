package ua.training.model.entities;

public class StaticSlide implements Slide {
    private Image image;


    @Override
    public Image showImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
