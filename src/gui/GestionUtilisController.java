/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author ACER EXTENSA 15
 */
public class GestionUtilisController implements Initializable {

    @FXML
    private ListView<String> tflist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       MyDB ds = new MyDB();
        Connection cnx = ds.getConnection();
        String req = "SELECT * from user";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                String Nom = rs.getString("Nom");
                String Prenom = rs.getString("Prenom");
                String Adress = rs.getString("Adress");
                String Role = rs.getString("Role");
                String Login = rs.getString("Login");
                String list = Nom + "  /  " + Prenom + "  /  "  + Adress + "  /  "  + Role + "  /  " + Login;
                tflist.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }    

    @FXML
    private void delete(ActionEvent event) {
        String requete = "DELETE FROM user WHERE Nom=?";
        int Nom=tflist.getSelectionModel().getSelectedIndex();
        tflist.getItems().remove(Nom);
    }
    
}
