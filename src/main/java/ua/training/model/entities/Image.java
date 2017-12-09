package ua.training.model.entities;

import java.time.LocalDate;

public interface Image {
    int getSize();
    Tag getTag();
    LocalDate getDateOfCreation();
    int getId();
    String getType();
    int getLength();
    int getHash();
}
