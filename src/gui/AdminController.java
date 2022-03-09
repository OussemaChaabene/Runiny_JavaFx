/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.abonnement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import service.abonnementservice;
import service.categorieaboservice;
import utils.datasource;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AdminController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtPrix;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField txtSalle;
    @FXML
    private ComboBox<String> CbxTy;
    @FXML
    private TableView<abonnement> listabo;
    @FXML
    private TextField Recherche;
    static abonnement selectedAbonnement;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categorieaboservice cs = new categorieaboservice();
        abonnementservice as = new abonnementservice();
        ArrayList arrayList = (ArrayList) cs.readAllNom();  
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        CbxTy.setItems(observableList);
        TableColumn<abonnement,Integer> idColumn = new TableColumn<>("ID");
        TableColumn<abonnement,String> nomColumn = new TableColumn<>("Nom");
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("ab_nom"));
        idColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn<abonnement,Integer> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("ab_type"));
        typeColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn<abonnement,Integer> prixColumn = new TableColumn<>("Prix");
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("ab_prix"));
        prixColumn.setStyle("-fx-alignment: CENTER;");
        TableColumn<abonnement,Integer> salleColumn = new TableColumn<>("Salle");
        salleColumn.setCellValueFactory(new PropertyValueFactory<>("ab_salle"));
        salleColumn.setStyle("-fx-alignment: CENTER;");
        ObservableList observableList1 = FXCollections.observableArrayList(as.readAll());
        listabo.setItems(observableList1);
        listabo.getColumns().addAll(idColumn,nomColumn,typeColumn,prixColumn,salleColumn);
        
        
        

    }
    private void list(){
        abonnementservice as = new abonnementservice();
        ObservableList observableList1 = FXCollections.observableArrayList(as.rechercheAbonnement(Recherche.getText()));
        listabo.setItems(observableList1);
        
    }
        
        // TODO

    
       

    @FXML
    private void ajout(ActionEvent event) {
        try {
            abonnement a = new abonnement();
            categorieaboservice cs = new categorieaboservice();
            abonnementservice as = new abonnementservice();
            a.setAb_id(Integer.parseInt(txtId.getText()));
            a.setAb_nom(txtNom.getText());
            a.setAb_prix(Integer.parseInt(txtPrix.getText()));
            a.setAb_type(cs.getId(CbxTy.getValue()));
            a.setAb_salle(Integer.parseInt(txtSalle.getText()));
            as.ajouterabonnement(a);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Abonnement ajouté");
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list();
    }

    @FXML
    private void Modifier(ActionEvent event) {
        try {
            abonnementservice as = new abonnementservice();
            categorieaboservice cs = new categorieaboservice();
            selectedAbonnement=listabo.getSelectionModel().getSelectedItem();
            abonnement a = new abonnement();
            
            a.setAb_nom(txtNom.getText());
            a.setAb_prix(Integer.parseInt(txtPrix.getText()));
            a.setAb_type(cs.getId(CbxTy.getValue()));
            a.setAb_salle(Integer.parseInt(txtSalle.getText()));
            as.modifier(a,selectedAbonnement.getAb_id());
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        list();
        
    }

    @FXML
    private void Supprimer(ActionEvent event) {
            selectedAbonnement = listabo.getSelectionModel().getSelectedItem();
            List<abonnement> listAbonnement = listabo.getSelectionModel().getSelectedItems();
            new abonnementservice().supprimer(listAbonnement.get(0).getAb_id());
            list();
        
    }

    private void Afficher(ActionEvent event) {
        list();
        
    }

    @FXML
    private void Rechercher(KeyEvent event) {
        abonnementservice as = new abonnementservice();
        ObservableList observabList = FXCollections.observableArrayList(as.rechercheAbonnement(Recherche.getText()));
        listabo.setItems(observabList);
       
    
}
}
