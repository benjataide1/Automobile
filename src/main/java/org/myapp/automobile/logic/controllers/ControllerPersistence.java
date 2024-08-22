package org.myapp.automobile.logic.controllers;

import org.myapp.automobile.logic.Automovil;

import java.util.List;

public class ControllerPersistence {

    AutomobileController automobileController = new AutomobileController();

    public void saveAutomobile(Automovil automovil) {
        automobileController.create(automovil);
    }

    public List<Automovil> allAutomobiles() {
        return automobileController.findAutomovilEntities();
    }

    public void delete(int idAutomovil) {
        automobileController.destroy(idAutomovil);
    }
}
