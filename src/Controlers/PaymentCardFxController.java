/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import entities.payement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PaymentCardFxController implements Initializable  {


    @FXML
    private Label username;
    @FXML
    private Label montant;
    @FXML
    private Label prix;
    @FXML
    private Label dates;
    
    private payement pay;
   
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void setData(payement pay) {
        
        montant.setText("2000"/*String.valueOf(pay.getMontant())*/);
        dates.setText(pay.getDate_pay());
        
    }
}
