/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import entities.payement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import runiny_javafx.MyListener;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PaymentCardFxController implements Initializable {

    @FXML
    private Pane achat;
    @FXML
    private Label username;
    @FXML
    private Label montant;
    @FXML
    private Label prix;
    @FXML
    private Label dates;
    
    private payement pay;
    private MyListener myListener;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(pay);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(payement pay, MyListener myListener) {
        this.pay = pay;
        this.myListener = myListener;
        montant.setText(Float.toString(pay.getMontant()));
        dates.setText(pay.getDate_pay().toString());
        /* priceLable.setText(Main.CURRENCY + fruit.getPrice());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        img.setImage(image);*/
    }
}
