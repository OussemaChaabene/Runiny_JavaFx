/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.stage.Window;
import jfx.messagebox.MessageBox;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class SupprimereventsController implements Initializable {

    @FXML
    private Button res;
    @FXML
    private ComboBox<String> evens;
    @FXML
    private Button supev;
    Connection conn = null;
    Statement st = null;
    String url = "jdbc:mysql://localhost:3306/runiny";
    String login = "root";
    String password = "";


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        get_reservations();
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
    private void retour(ActionEvent event) throws IOException {
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("my resevents.fxml"));
                Scene scene4=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene4);
                window.show();
    }
    private void get_reservations() {
        evens.getItems().clear();
        Connection conn = null;
        Statement st = null;
        String getres = "SELECT *  FROM reservation where id_even =! Null";
        try {
            conn = (Connection) DriverManager.getConnection(url, login, password);
            ResultSet rs1 = conn.createStatement().executeQuery(getres);
            while (rs1.next()) {
                String dateres = rs1.getString(1);
                String dater = rs1.getString("date");
                evens.getItems().addAll(dater);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void supprimeven(ActionEvent event) {
        String resdate = evens.getValue();
        try
    {
        conn = (Connection) DriverManager.getConnection(url, login, password);
        String rmvres="Delete from reservation where date='"+resdate+"'";
        PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(rmvres);
        preparedStmt.execute();
        //dialog box
        Window primaryStage = null;
        MessageBox.show(primaryStage,
         "Reservation supprimée",
         "Information dialog",
         MessageBox.OK);
        //actualisation de la scene
        Parent fxml1;
        fxml1 = FXMLLoader.load(getClass().getResource("supprimerevents.fxml"));
                Scene scene8=new Scene(fxml1);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene8);
                window.show();
        }
    catch (Exception e)
    {
      System.err.println(e.getMessage());
    }
    }
    
}
