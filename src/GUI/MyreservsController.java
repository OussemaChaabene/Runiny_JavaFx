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
public class MyreservsController implements Initializable {

    @FXML
    private Button res;
    @FXML
    private Button retour;
    @FXML
    private Button supprimresprv;
    @FXML
    private Button modifresprv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void reservation(ActionEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("GUI/reservation.fxml"));
        Scene scene3 = new Scene(fxml);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }
    @FXML
    private void reReservSPRIV(ActionEvent event) throws IOException {
        Parent fxml1=FXMLLoader.load(getClass().getResource("ReservSPRIV.fxml"));
                Scene scene4=new Scene(fxml1);
                Stage window1 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(scene4);
                window1.show();
    }
    @FXML
    private void suprimReservSPRIV(ActionEvent event) throws IOException {
        Parent fxml1=FXMLLoader.load(getClass().getResource("suprimresprv.fxml"));
                Scene scene6=new Scene(fxml1);
                Stage window1 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(scene6);
                window1.show();
    }
    @FXML
    private void modifReservSPRIV(ActionEvent event) throws IOException {
        Parent fxml1=FXMLLoader.load(getClass().getResource("modifrespriv.fxml"));
                Scene scene7=new Scene(fxml1);
                Stage window1 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(scene7);
                window1.show();
    }
    private void afficheres(){
        
    }
}
