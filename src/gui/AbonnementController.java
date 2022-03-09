/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.abonnement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.datasource;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AbonnementController implements Initializable {

    @FXML
    private TextField tfutilis;
    @FXML
    private ListView<String> listabo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datasource ds = new datasource();
        Connection cnx = ds.getCnx();
        String req = "SELECT * from abonnement";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                String ab_nom = rs.getString("ab_nom");
                String ab_type = rs.getString("ab_type");
                String ab_prix = rs.getString("ab_prix");
                String ab_salle = rs.getString("ab_salle");
                String list = ab_nom + "/" + ab_type + "/" + ab_prix + "/" + ab_salle;
                listabo.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }

    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Payement.fxml"));
        Scene scene3 = new Scene(fxml);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }

}
