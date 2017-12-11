package ua.training.model.dao;

import ua.training.model.entities.Image;
import ua.training.model.entities.Tag;

import java.time.LocalDate;
import java.util.List;

public interface ImageDao extends AutoCloseable {
    List<Image> getAllImages();
    Image findById(int id);
    List<Image> getBetweenSize(int minSize, int maxSize);
    List<Image> getBetweenDate(LocalDate firstDate, LocalDate secondDate);
    List<Image> getByTag(Tag tag);
    void delete();
    void update();
}
