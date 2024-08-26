package org.myapp.automobile.igu.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.myapp.automobile.logic.Automovil;
import org.myapp.automobile.logic.Controller;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GetUpDelController implements Initializable {


    public TableView tableView;
    public TableColumn id_get;
    public TableColumn model;
    public TableColumn brand;
    public TableColumn motor;
    public TableColumn color;
    public TableColumn patent;
    public TableColumn doors;
    public Button btBack;
    public Button btUpdate;

    Controller controller = new Controller();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cargaTabla();
    }

    public void cargaTabla() {

        tableView.getItems().clear();

        // Asigo las propiedas que van a recibir las columnas de mi Object Automovil
        id_get.setCellValueFactory(new PropertyValueFactory<>("id_Automovil"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        motor.setCellValueFactory(new PropertyValueFactory<>("motor"));
        color.setCellValueFactory(new PropertyValueFactory<>("color"));
        patent.setCellValueFactory(new PropertyValueFactory<>("patente"));
        doors.setCellValueFactory(new PropertyValueFactory<>("countPuertas"));

        if (controller.allAutomobiles() != null) {
            controller.allAutomobiles().forEach((p) ->
                    tableView.getItems().addAll(p));


        }
    }

    public void btnDelete(ActionEvent actionEvent) {
        // Obtener la fila seleccionada
        Automovil selectedAutomovil = (Automovil) tableView.getSelectionModel().getSelectedItem();

        if (tableView.getItems().stream().count() != 0 || selectedAutomovil != null) {

            controller.delete(selectedAutomovil.getId_Automovil());
            showMessage("Automobile Delete successfully", "Info", "Delete successfully");
            cargaTabla();

        } else {
            showMessage("Is Empty", "Error", "Error When Deleting");
        }
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

    public void btnUpdate(ActionEvent actionEvent) {
        // Obtener la fila seleccionada
        Automovil selectedAutomovil = (Automovil) tableView.getSelectionModel().getSelectedItem();

        if (selectedAutomovil != null) {
            Stage stage = null;
            Parent root = null;

            try {
                // Obtén la referencia al botón
                stage = (Stage) btUpdate.getScene().getWindow();

                // Configurar el FXMLLoader
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/myapp/automobile/update.fxml"));

                // Cargar el nuevo FXML
                root = loader.load();

                // Obtener el controlador asociado al FXML
                UpdateController controller = loader.getController();

                // Pasar el ID del automóvil al controlador
                controller.findCar(selectedAutomovil.getId_Automovil());

                // Opción alternativa: pasar el objeto Automovil completo
                // controller.setAutomovil(selectedAutomovil);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // Configurar la escena y mostrarla
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            showMessage("Is Empty", "Error", "Error When Updating");
        }
    }



}
