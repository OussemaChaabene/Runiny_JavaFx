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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class ModifresprivController implements Initializable {

    @FXML
    private Button res;
    @FXML
    private Button ret;
    @FXML
    private ComboBox<?> rsch;
    @FXML
    private Button mdf;
    @FXML
    private ComboBox<?> coch;
    @FXML
    private ComboBox<?> sls;

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
    public void modifres(ActionEvent event) throws IOException {
        
        
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("modifrespriv.fxml"));
                Scene scene8=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene8);
                window.show();}

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("myreservs.fxml"));
                Scene scene9=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene9);
                window.show();}
    
}
