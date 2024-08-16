package org.myapp.automobile.igu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    public void btnClean(ActionEvent actionEvent)  {
        System.out.println("Hello-World");

    }
}

