/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class ReservationController implements Initializable {

    @FXML
    private Button resSP;
    @FXML
    private Button resevent;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void reservation(ActionEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("reservation.fxml"));
                Scene scene3=new Scene(fxml);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();
    }
    @FXML
    private void RSPRIV(ActionEvent event) throws IOException {
        Parent fxml1=FXMLLoader.load(getClass().getResource("ReservSPRIV.fxml"));
                Scene scene4=new Scene(fxml1);
                Stage window1 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(scene4);
                window1.show();
    }
    @FXML
    private void reservEvent(ActionEvent event) throws IOException {
        Parent fxml2=FXMLLoader.load(getClass().getResource("reservEvent.fxml"));
                Scene scene5=new Scene(fxml2);
                Stage window2 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window2.setScene(scene5);
                window2.show();
 }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent fxml3=FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene6=new Scene(fxml3);
                Stage window2 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window2.setScene(scene6);
                window2.show();
    }
}