/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.EnvoyerEmail;
import entitie.User;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import service.UserCRUD;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author ACER EXTENSA 15
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAdress;
    @FXML
    private TextField tfDn;
    @FXML
    private Label tfRole;
    @FXML
    private TextField tfEmail;
    @FXML
    private PasswordField tfPwd;
    @FXML
    private Button btnajouter;
    @FXML
    private RadioButton rclient;
    @FXML
    private RadioButton radmin;
    @FXML
    private RadioButton rcoach;
    @FXML
    private ToggleGroup Rolee;
    @FXML
    private Label errorlab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void getrole(ActionEvent event) {
        if (rclient.isSelected()) {
            tfRole.setText(rclient.getText());
        } else if (radmin.isSelected()) {
            tfRole.setText(radmin.getText());
        } else if (rcoach.isSelected()) {
            tfRole.setText(rcoach.getText());
        }
        String Role = tfRole.getText();
    }

    @FXML
    private void ajouterUser(ActionEvent event) throws SQLException, IOException {
        String Nom = tfNom.getText();
        String Prenom = tfPrenom.getText();
        String Adress = tfAdress.getText();
        String Date_naiss = tfDn.getText();
        String Role = tfRole.getText();
        String Login = tfEmail.getText();
        String Password = tfPwd.getText();
        if (Login.isEmpty() || Password.isEmpty() || Nom.isEmpty() || Prenom.isEmpty() || Adress.isEmpty() || Date_naiss.isEmpty() || Role.isEmpty()) {
            errorlab.setText("Please complete all the fills");
        } else if (Login.charAt(0) != '@' && Login.contains("@") && Login.endsWith(".com") || Login.endsWith(".tn") || Login.endsWith(".fr")) {
            errorlab.setText("Please enter a valide email");
            if (Password.length() < 8) {
                errorlab.setText("Password is too weak, please choose atleast 8 characters");
            } else {
                String requete = ("select * from user where Login=?");
                PreparedStatement pst = new MyDB().getConnection().prepareStatement(requete);
                pst.setString(1, Login);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    errorlab.setText("Username already taken, please try another username");
                }
                User u = new User(Nom, Prenom, Adress, Login, Password, Role, Date_naiss);
                UserCRUD ud = new UserCRUD();
                ud.ajouterUser2(u);
                EnvoyerEmail test = new EnvoyerEmail();
                test.envoyer(Login);
            }
            Parent fxml = FXMLLoader.load(getClass().getResource("SigIn.fxml"));
            Scene scene3 = new Scene(fxml);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene3);
            window.show();
        }

    }
}
