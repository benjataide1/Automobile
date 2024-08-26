package org.myapp.automobile.logic;

import org.myapp.automobile.logic.controllers.ControllerPersistence;

import java.util.List;

public class Controller {
    ControllerPersistence persistence = new ControllerPersistence();

    public void saveAutomobile(String model, String brand, String motor, String color, String patent, int countDoors) {
        Automovil automovil = new Automovil(model, brand, motor, color, patent, countDoors);
        persistence.saveAutomobile(automovil);

    }

    public List<Automovil> allAutomobiles() {
        return persistence.allAutomobiles();
    }

    public void delete(int idAutomovil) {
        persistence.delete(idAutomovil);
    }

    public Automovil findAutomovil(int idAutomovil) {
        return persistence.findAutomovil(idAutomovil);
    }

    public void editAutomobil(int idAutomovil, String model, String brand, String motor, String color, String patent, int countDoors) throws Exception {

        Automovil automovil = findAutomovil(idAutomovil);

        if (automovil != null) {

            automovil.setModel(model);
            automovil.setBrand(brand);
            automovil.setMotor(motor);
            automovil.setColor(color);
            automovil.setPatente(patent);
            automovil.setCountPuertas(countDoors);


            persistence.editAutomovil(automovil);
        } else {
            throw new Exception("Not find Automovil.");
        }

    }
}