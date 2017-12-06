package ua.training;

import ua.training.controller.Controller;
import ua.training.model.SlideShowModel;
import ua.training.model.dao.DaoFactory;
import ua.training.view.View;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new SlideShowModel(DaoFactory.getInstance().createImageDao()), new View());
        controller.processUser();
    }
}
