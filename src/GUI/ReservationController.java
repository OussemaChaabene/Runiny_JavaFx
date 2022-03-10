/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import entitites.Reserv;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Double.NaN;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class ReservationController implements Initializable {

    @FXML
    private Button resSP;
    @FXML
    private Button resevent;
    Connection conn = null;
    Statement st = null;
    String url = "jdbc:mysql://localhost:3306/runiny";
    String login = "root";
    String password = "";
        private TableView<Reserv> allReservation;
    private TableColumn<Reserv,Integer> id_reser;
    private TableColumn<Reserv, Integer> date;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    @FXML
    private void reservation(ActionEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("reservation.fxml"));
                Scene scene3=new Scene(fxml);
                Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene3);
                window.show();
    }
    @FXML
    private void RSPRIV(ActionEvent event) throws IOException {
        Parent fxml1=FXMLLoader.load(getClass().getResource("ReservSPRIV.fxml"));
                Scene scene4=new Scene(fxml1);
                Stage window1 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(scene4);
                window1.show();
    }
    @FXML
    private void reservEvent(ActionEvent event) throws IOException {
        Parent fxml2=FXMLLoader.load(getClass().getResource("reservEvent.fxml"));
                Scene scene5=new Scene(fxml2);
                Stage window2 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window2.setScene(scene5);
                window2.show();
 }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent fxml3=FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene6=new Scene(fxml3);
                Stage window2 =(Stage)((Node)event.getSource()).getScene().getWindow();
                window2.setScene(scene6);
                window2.show();
    }
    @FXML
    public void OnClickedPrint(ActionEvent event) throws IOException{
         try {

            OutputStream file = new FileOutputStream(new File("D:reservation.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            document.add(new Paragraph("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Mes Reservations ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n\n\n\n"));

            document.add(new Paragraph(" ___________________________________________________________________________\n"));
            document.add(new Paragraph(" Date des Reservations :"));
            String dater=null;
            Connection conn = null;
        Statement st = null;
        String getres = "SELECT *  FROM reservation where id_even=Null";
        
            conn = (Connection) DriverManager.getConnection(url, login, password);
            ResultSet rs1 = conn.createStatement().executeQuery(getres);
            
            while (rs1.next()) {
                String dateres = rs1.getString(1);
                dater = rs1.getString("date");
                if (dater==null) {
                    document.add(new Paragraph("aucune reservation \n"));
                } else {
                    document.add(new Paragraph(dater+"\n"));
                }
{
                
            }
                
            }

        
    
            
            document.add(new Paragraph(" ___________________________________________________________________________"));

            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Mes Reservations ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"));
            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        
    }
}