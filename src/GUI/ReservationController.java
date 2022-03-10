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
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public ObservableList<Reserv> getReservationList() throws SQLException{
        ObservableList<Reserv> ReservationList = FXCollections.observableArrayList();
        conn = (Connection) DriverManager.getConnection(url, login, password);
        String query = "SELECT * FROM reservation";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Reserv Reserva;
            while(rs.next()){
                Reserva = new Reserv(rs.getInt("id_res"), rs.getString("date"));
                ReservationList.add(Reserva);
            }
                
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return ReservationList;
    }
             public void showReservation() throws SQLException{
        ObservableList<Reserv> list = getReservationList();
        
        id_reser.setCellValueFactory(new PropertyValueFactory<Reserv, Integer>("id_res"));
        date.setCellValueFactory(new PropertyValueFactory<Reserv, Integer>("Date"));
        
        
        allReservation.setItems(list);
    }
    private void CreatePDF(ActionEvent event) throws SQLException, IOException, DocumentException {
    
     try {
       Document doc = new Document();
       PdfWriter.getInstance(doc,new FileOutputStream("C:\\Users\\mayro\\Desktop\\Pi runiny\\Evenement.pdf"));  
       doc.open();
    
       doc.add(new Paragraph(" "));
       Font font = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.BLACK);
       Paragraph p = new Paragraph("Vos reservations ", font);
       p.setAlignment(Element.ALIGN_CENTER);
       doc.add(p);
       doc.add(new Paragraph(" "));
       doc.add(new Paragraph(" "));
 

       PdfPTable tabpdfprv = new PdfPTable(2);
       tabpdfprv.setWidthPercentage(100);
       PdfPCell cell;
       cell = new PdfPCell(new Phrase("nom", FontFactory.getFont("Times New Roman", 11)));
       cell.setHorizontalAlignment(Element.ALIGN_CENTER);
       cell.setBackgroundColor(BaseColor.WHITE);
       tabpdfprv.addCell(cell);

        String query = "SELECT * FROM reservation";
        conn = (Connection) DriverManager.getConnection(url, login, password);
          Statement st;
          ResultSet rs;
          st = conn.createStatement();
          rs = st.executeQuery(query);
    
      while (rs.next()) {
           cell = new PdfPCell(new Phrase("id_reser", FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdfprv.addCell(cell);
     
           cell = new PdfPCell(new Phrase(rs.getString("date"), FontFactory.getFont("Times New Roman", 11)));
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setBackgroundColor(BaseColor.WHITE);
           tabpdfprv.addCell(cell);
     
   
          doc.add(tabpdfprv);
          JOptionPane.showMessageDialog(null, "Success !!");
          doc.close();
          Desktop.getDesktop().open(new File("C:\\Users\\mayro\\Desktop\\Pi runiny\\Evenement.pdf"));
       }
     }
        catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
          }
    
 }
    @FXML
    private void OnClickedPrint(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
       
        Node root= this.allReservation;
       
       
     if(job != null){
     job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
     Printer printer = job.getPrinter();
     PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
     boolean success = job.printPage(pageLayout, root);
     if(success){
        job.endJob();
        
        
     }
     }
    }
}