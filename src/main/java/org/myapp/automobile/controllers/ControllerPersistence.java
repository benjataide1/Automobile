package org.myapp.automobile.controllers;

import org.myapp.automobile.logic.Automovil;

public class ControllerPersistence {

    AutomobileController automobileController = new AutomobileController();

    public void saveAutomobile(Automovil automovil) {
        automobileController.create(automovil);
    }
}
