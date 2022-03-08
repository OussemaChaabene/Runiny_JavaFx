/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entitie.User;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import service.UserCRUD;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author ACER EXTENSA 15
 */
public class GestionUtilisController implements Initializable {

    @FXML
    private ListView<String> tflist;
    @FXML
    private ToggleGroup Rolee;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfadress;
    @FXML
    private TextField tfdate;
    @FXML
    private TextField tflog;
    @FXML
    private TextField tfpwd;
    @FXML
    private Label fRole;
    @FXML
    private RadioButton coach;
    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton client;

    /**
     * Initializes the controller class.
     */
   
      @FXML
    private void add(ActionEvent event) {
        String Nom = tfnom.getText();
        String Prenom = tfprenom.getText();
        String Adress = tfadress.getText();
        String Date_nais = tfdate.getText();
        String Role=fRole.getText();
        String Login=tflog.getText();
        String Password=tfpwd.getText();
        User u = new User();
        u.setNom(Nom);
        u.setPrenom(Prenom);
        u.setAdress(Adress);
        u.setDate_naiss(Date_nais);
        UserCRUD ud = new UserCRUD();
        ud.ajouterUser2(u);

    }
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
                String list = Nom + "  /  " + Prenom + "  /  " + Adress + "  /  " + Role + "  /  " + Login;
                tflist.getItems().add(list);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        String requete = "DELETE FROM user WHERE Nom=?";
        int Nom = tflist.getSelectionModel().getSelectedIndex();
        tflist.getItems().remove(Nom);
    }

     @FXML
    private void getrole(ActionEvent event) {
           if (client.isSelected()) {
            fRole.setText(client.getText());
        } else if (admin.isSelected()) {
            fRole.setText(admin.getText());
        } else if (coach.isSelected()) {
           fRole.setText(coach.getText());
        
        String Role = fRole.getText();
    }

  

}
}
