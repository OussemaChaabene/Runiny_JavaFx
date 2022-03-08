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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class SuprimresprvController implements Initializable {

    @FXML
    private Button res;
    @FXML
    private ComboBox<?> ress;
    @FXML
    private TextField affcoach;
    @FXML
    private TextField affsalle;
    @FXML
    private TextField affdate;
    @FXML
    private Button retour;
    @FXML
    private Button supp;
    @FXML
    private TextField afftmp;

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
        fxml = FXMLLoader.load(getClass().getResource("reservation.fxml"));
                Scene scene3=new Scene(fxml);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();}
    @FXML
    private void ret(ActionEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("myreservs.fxml"));
                Scene scene8=new Scene(fxml);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene8);
                window.show();}
    @FXML
    private void supprimerres(ActionEvent event)throws IOException{
        
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("suprimresprv.fxml"));
                Scene scene8=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene8);
                window.show();
    }
}
