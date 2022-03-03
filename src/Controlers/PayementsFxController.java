/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlers;

import Services.PayementService;
import entities.payement;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PayementsFxController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        PayementService pserv = new PayementService();
        List<payement> pl = new ArrayList<>();
        pl.addAll(pserv.afficherPs());

        int column = 0;
        int row = 0;

        try {
            for (int i = 0; i < pl.size(); i++) {
                FXMLLoader fl = new FXMLLoader();

                fl.setLocation(getClass().getResource("../GUI/PaymentCardFx.fxml"));

                AnchorPane anchorPane = fl.load();

                PaymentCardFxController ic = fl.getController();

                try {
                    ic.setData(pl.get(i));

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("test");

                if (column == 2) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
