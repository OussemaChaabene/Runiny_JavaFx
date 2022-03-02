/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runiny_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Metier.PayementM;
import Services.PayementService;
import entities.payement;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class FXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        payement p = new payement();
        p.setMontant(2000);
        p.setDate_pay(java.sql.Date.valueOf(LocalDate.now()));
        PayementService ps = new PayementService();

        Parent root = FXMLLoader.load(getClass().getResource("../GUI/PayementsFx.fxml"));
        Scene scene = new Scene(root); 
        primaryStage.setTitle("Payements");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
