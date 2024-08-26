package org.myapp.automobile.igu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import org.myapp.automobile.logic.Automovil;
import org.myapp.automobile.logic.Controller;

import javax.swing.*;
import java.io.IOException;


public class UpdateController {

    public Button btBack;
    public TextField txtModel;
    public TextField txtBrand;
    public TextField txtMotor;
    public TextField txtColor;
    public TextField txtPatent;
    public TextField txtDoors;
    private int idAutomovil;

    Controller controller = new Controller();


    public void findCar( int idAutomovil) throws Exception {
        this.idAutomovil = idAutomovil;

        Automovil car = controller.findAutomovil(idAutomovil);
        if (car != null) {
            txtModel.setText(car.getModel());
            txtBrand.setText(car.getBrand());
            txtMotor.setText(car.getMotor());
            txtColor.setText(car.getColor());
            txtPatent.setText(car.getPatente());
            txtDoors.setText(String.valueOf(car.getCountPuertas()));
        }

    }


    public void btnBack(ActionEvent actionEvent) {

        Stage stage = null;
        Parent root = null;

        try {
            // Obtén la referencia al botón
            stage = (Stage) btBack.getScene().getWindow();

            // Carga el nuevo FXML
            root = FXMLLoader.load(getClass().getResource("/org/myapp/automobile/get_update_del.fxml"));
        } catch (IOException e) {
            e.getMessage();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void btnClean(ActionEvent actionEvent) {

        txtModel.setText("");
        txtBrand.setText("");
        txtMotor.setText("");
        txtColor.setText("");
        txtPatent.setText("");
        txtDoors.setText("");
    }


    public void btnUpdate(ActionEvent actionEvent) throws Exception {

        String model = txtModel.getText();
        String brand = txtBrand.getText();
        String motor = txtMotor.getText();
        String color = txtColor.getText();
        String patent = txtPatent.getText();
        int countDoors = Integer.parseInt(txtDoors.getText());

        controller.editAutomobil(idAutomovil,model, brand, motor, color, patent, countDoors);

        showMessage("Update Succesfully", "Info", "UPDATE");

        btnBack(actionEvent);


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
