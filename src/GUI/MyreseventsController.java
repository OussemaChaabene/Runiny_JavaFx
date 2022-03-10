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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class MyreseventsController implements Initializable {

    @FXML
    private Button res;
    @FXML
    private ListView<?> affevents;
    @FXML
    private Button suppevent;

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
                window.show();
    }

    private void modifevent(ActionEvent event) throws IOException {
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("modifierevents.fxml"));
                Scene scene4=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene4);
                window.show();
    }

    @FXML
    private void supprimevent(ActionEvent event) throws IOException {
        Parent fxml2;
        fxml2 = FXMLLoader.load(getClass().getResource("supprimerevents.fxml"));
                Scene scene5=new Scene(fxml2);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene5);
                window.show();
    }
    
}
