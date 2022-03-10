/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runiny_javafx;

import Services.PayementService;
import entities.payement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;

import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.itextpdf.text.Document;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class FXMain extends Application {

    public static final String CURRENCY = "$";

    public void start(Stage primaryStage) throws Exception {

       
        /*
        Parent root = FXMLLoader.load(getClass().getResource("PayementsHistory.fxml"));
        primaryStage.setTitle("Payements");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
