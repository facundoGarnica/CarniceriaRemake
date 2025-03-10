/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package CrearVentas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author garca
 */
public class CrearVentasController implements Initializable {
    private Stage menuStage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void VolverAlMenu(ActionEvent event) {
    try {
        if (menuStage == null) {
            // Si no se ha cargado la ventana principal, la creamos
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MenuPrincipal/MenuPrincipal.fxml"));
            Parent root = loader.load();
            menuStage = new Stage();
            menuStage.setTitle("Menu Principal");
            menuStage.setScene(new Scene(root));
        }
        // Mostramos la ventana principal
        menuStage.show();
        
        // Cerrar la ventana actual
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
}
