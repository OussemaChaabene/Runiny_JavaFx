/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runiny_javafx;

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
public class Runiny_javaFx {

    
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/PayementsFx.fxml"));
        primaryStage.setTitle("Payements");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        payement p = new payement();
        p.setMontant(2000);
        p.setDate_pay(java.sql.Date.valueOf(LocalDate.now()));
        PayementService ps= new PayementService();
        ps.ajouterP(p);
        launch(args);
        
    }
}
