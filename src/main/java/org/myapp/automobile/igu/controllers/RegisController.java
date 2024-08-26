package org.myapp.automobile.igu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.myapp.automobile.logic.Controller;

import javax.swing.*;
import java.io.IOException;

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
    public Button btBack;

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

        Stage stage = null;
        Parent root = null;

        try {
            String model = txtModel.getText();
            String brand = txtBrand.getText();
            String motor = txtMotor.getText();
            String color = txtColor.getText();
            String patent = txtPatent.getText();
            int countDoors = Integer.parseInt(txtDoors.getText());

            controller.saveAutomobile(model, brand, motor, color, patent, countDoors);

            showMessage("Automobile Save", "Info", "successfully");

            // Obtén la referencia al botón
            stage = (Stage) btBack.getScene().getWindow();

            // Carga el nuevo FXML
            root = FXMLLoader.load(getClass().getResource("/org/myapp/automobile/main-view.fxml"));

        } catch (IOException e) {
            e.getMessage();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void btnBack(ActionEvent actionEvent) {
        Stage stage = null;
        Parent root = null;

        try {
            // Obtén la referencia al botón
            stage = (Stage) btBack.getScene().getWindow();

            // Carga el nuevo FXML
            root = FXMLLoader.load(getClass().getResource("/org/myapp/automobile/main-view.fxml"));
        } catch (IOException e) {
            e.getMessage();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void showMessage(String message, String type, String title) {
        JOptionPane optionPane = new JOptionPane(message);
        if (type.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (type.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}


