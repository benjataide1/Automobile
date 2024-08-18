package org.myapp.automobile.igu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.myapp.automobile.logic.Controller;

public class RegisController {
    @FXML
    public TextField txtModel;

    @FXML
    public TextField txtBrand;

    @FXML
    public TextField txtMotor;

    @FXML
    public TextField txtColor;

    @FXML
    public TextField txtPatent;

    @FXML
    public TextField txtDoors;

    Controller controller = new Controller();

    public void btnClean(ActionEvent actionEvent) {
        txtModel.setText("");
        txtBrand.setText("");
        txtMotor.setText("");
        txtColor.setText("");
        txtPatent.setText("");
        txtDoors.setText("");

    }

    public void btnSave(ActionEvent actionEvent) {
        String model = txtModel.getText();
        String brand = txtBrand.getText();
        String motor = txtMotor.getText();
        String color = txtColor.getText();
        String patent = txtPatent.getText();
        int countDoors = Integer.parseInt(txtDoors.getText());

        controller.saveAutomobile(model, brand, motor, color, patent, countDoors);
    }
}

