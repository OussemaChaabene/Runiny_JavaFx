/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ReservCrud;
import com.mysql.jdbc.Connection;
import entitites.Reserv;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import utilities.MyDB;

/**
 * FXML Controller class
 *
 * @author mayro
 */
public class ReservSPRIVController implements Initializable {

    @FXML
    private DatePicker date;
    @FXML
    private Spinner<Integer> heure;
    @FXML
    private Spinner<Integer> minutes;
    @FXML
    private ComboBox<String> coach;
    Integer curheure;
    Integer curmin;
    final ObservableList options = FXCollections.observableArrayList();
    Connection conn = null;
    Statement st = null;
    String url = "jdbc:mysql://localhost:3306/runiny";
    String login = "root";
    String password = "";

    @FXML
    private ComboBox<String> sll;
    @FXML
    private Button mrs;
    @FXML
    private Button resSPRi;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SpinnerValueFactory<Integer> valueFactoryh = new SpinnerValueFactory.IntegerSpinnerValueFactory(9, 18);
        valueFactoryh.setValue(9);
        heure.setValueFactory(valueFactoryh);
        curheure = heure.getValue();
        SpinnerValueFactory<Integer> valueFactorym = new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 59);
        valueFactoryh.setValue(00);
        minutes.setValueFactory(valueFactorym);
        curmin = minutes.getValue();
        heure.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                curheure = heure.getValue();
                curmin = minutes.getValue();
            }
        });

        remplir_coachcomb();
        remplir_salle();

    }

    @FXML
    private void reservation(ActionEvent event) throws IOException {
        Parent fxml;
        fxml = FXMLLoader.load(getClass().getResource("GUI/reservation.fxml"));
        Scene scene3 = new Scene(fxml);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }
    @FXML
    private void remplir_coachcomb() {
        coach.getItems().clear();
        Connection conn = null;
        Statement st = null;
        String fulname = "SELECT *  FROM user where role='coach'";

        try {
            conn = (Connection) DriverManager.getConnection(url, login, password);

            ResultSet rs1 = conn.createStatement().executeQuery(fulname);
            while (rs1.next()) {
                String finame = rs1.getString(1);
                String laname = rs1.getString(1);
                String funame = rs1.getString("Prenom") + " " + rs1.getString("Nom");
                coach.getItems().addAll(funame);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void remplir_salle() {
        String Sname = "SELECT * FROM salle";

        try {
            conn = (Connection) DriverManager.getConnection(url, login, password);

            ResultSet rs2 = conn.createStatement().executeQuery(Sname);
            while (rs2.next()) {
                String nsalle = rs2.getString(1);
                sll.getItems().addAll(rs2.getString("nom"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private void reSpriv() {
        String chc = "Select id_user from user where Prenom,Nom =" + coach.getValue() + "";
        String datpick = (date.getValue().format(DateTimeFormatter.ofPattern("yyyy-mm-dd"))).toString();
        String dt = datpick + curheure + curmin;
        Reserv sp = new Reserv();
        sp.setId_reser(1);
        sp.setDate(dt);
        sp.setId_salle(0);
        sp.setId_coach(parseInt(chc));
        sp.setId_even(NULL);
        ReservCrud rsp = new ReservCrud();
        rsp.ajouterReserv(sp);
    }
    @FXML
    private void mres(ActionEvent event) throws IOException {
        Parent fxml2 = FXMLLoader.load(getClass().getResource("myreservs.fxml"));
        Scene scene5 = new Scene(fxml2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene5);
        window.show();
    }

}
