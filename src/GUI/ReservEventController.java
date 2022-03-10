/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mysql.jdbc.Connection;
import entitites.Reserv;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class ReservEventController implements Initializable {

    @FXML
    private TextArea date;
    @FXML
    private TextArea desceven;
    @FXML
    private TextArea salleeve;
    @FXML
    private Button reserver;
    @FXML
    private ComboBox<String> eventschombo;
    @FXML
    private Button ret;
    @FXML
    private Button myevents;
    Connection conn = null;
    Statement st = null;
    String url = "jdbc:mysql://localhost:3306/runiny";
    String login = "root";
    String password = "";

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        remplir_eventcombo();
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
    private void remplir_eventcombo() {
        eventschombo.getItems().clear();
        Connection conn = null;
        Statement st = null;
        String evenname = "SELECT *  FROM evenement";

        try {
            conn = (Connection) DriverManager.getConnection(url, login, password);

            ResultSet rs1 = conn.createStatement().executeQuery(evenname);
            while (rs1.next()) {
                String finame = rs1.getString(1);
                String evname = rs1.getString("nomeven");
                eventschombo.getItems().addAll(evname);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void afficherdetail(){
        String se=eventschombo.getSelectionModel().getSelectedItem();
        
    }
    @FXML
    private void reserverEvent(ActionEvent event)throws IOException {
        String ev=eventschombo.getValue();
        String cev = "Select * from evenement where nom_even ='"+ev+"'";
        Reserv resev=new Reserv();
        resev.setId_reser(1);
        try {
            conn = (Connection) DriverManager.getConnection(url, login, password);

            ResultSet rs4 = conn.createStatement().executeQuery(cev);
            while (rs4.next()) {
                int numcoach = rs4.getInt(1);
                resev.setId_even(rs4.getInt("id_even"));
                resev.setId_coach(NULL);
                resev.setId_salle(rs4.getInt("id_salle"));
                resev.setDate(rs4.getString("Date"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        

    @FXML
    private void myeves(ActionEvent event) throws IOException {
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("reservation.fxml"));
                Scene scene1=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene1);
                window.show();
    }

}
