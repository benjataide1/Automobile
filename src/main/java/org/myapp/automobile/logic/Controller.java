package org.myapp.automobile.logic;

import org.myapp.automobile.logic.controllers.ControllerPersistence;

public class Controller {
    ControllerPersistence persistence = new ControllerPersistence();

    public void saveAutomobile(String model, String brand, String motor, String color, String patent, int countDoors) {
        Automovil automovil = new Automovil(model,brand,motor,color,patent,countDoors);
        persistence.saveAutomobile(automovil);

    }
}
