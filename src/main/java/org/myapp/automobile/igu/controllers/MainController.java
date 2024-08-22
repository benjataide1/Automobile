package org.myapp.automobile.igu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    public Button buttonRegis;
    public Button buttonGDU;

    public void btnRegistration(ActionEvent actionEvent) throws IOException {

//        System.out.println("Hello");

        Stage stage;
        Parent root;

        // Obtén la referencia al botón
        stage = (Stage) buttonRegis.getScene().getWindow();

        // Carga el nuevo FXML
        root = FXMLLoader.load(getClass().getResource("/org/myapp/automobile/registration.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void getUpDel(ActionEvent actionEvent) throws IOException {

        Stage stage;
        Parent root;

        // Obtén la referencia al botón
        stage = (Stage) buttonGDU.getScene().getWindow();

        // Carga el nuevo FXML
        root = FXMLLoader.load(getClass().getResource("/org/myapp/automobile/get_update_del.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
