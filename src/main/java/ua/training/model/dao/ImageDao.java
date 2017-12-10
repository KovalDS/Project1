package ua.training.model.dao;

import ua.training.model.entities.Image;

import java.util.List;

public interface ImageDao extends AutoCloseable {
    List<Image> getAllImages();
    Image findById(int id);
    List<Image> getImagesBeetwenDate();
    List<Image> getImagesByTag();
    List<Image> getImagesBeetwenSize();
    void delete();
    void update();
}
