package Services;

import entitites.Reserv;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utilities.MyDB;

public class ReservCrud {
    public void ajouterReserv(Reserv r){
        try {
            String requete = "INSERT INTO reservation (id_reser,id_even,id_coach,id_salle,date)"
                    + "VALUES(?,?,?,?)";
            PreparedStatement st = new MyDB().getConnection().prepareStatement(requete);
            
            st.setInt(1, r.getId_reser());
            st.setInt(2, r.getId_even());
            st.setInt(3, r.getId_coach());
            st.setInt(4, r.getId_salle());
            st.setString(5, r.getDate());
            st.executeUpdate();
            //
            //st.executeUpdate(requete);
            System.out.println("Reservation ajoutée avec succés");
        } catch (SQLException ex) {
            System.err.println (ex.getMessage());
        }
    }
    public void supprimerReserv(int id_reser){
        try {
            String requete4 = "DELETE FROM reservation WHERE id_reser='"+id_reser+ "'\"";
            Statement st = new MyDB().getConnection().createStatement();
            st.executeUpdate(requete4);
            System.out.println("Reservation supprimé avec succés");
        } catch (SQLException ex) {
            System.err.println (ex.getMessage());
        }
    }
    public void modifierReserv(int id_reser){
        try {
            String requete5 = "Update reservation SET nom=? Where id_reser="+id_reser;
            Statement st = new MyDB().getConnection().createStatement();
            st.executeUpdate(requete5);
            System.out.println("Reservation modifiée avec succés");
        } catch (SQLException ex) {
            System.err.println (ex.getMessage());
        }
    }
    public List<Reserv> afficherReservpriv(int id_user){
        List<Reserv> myList = new ArrayList<>();
        try {
            String requete3 = "SELECT date FROM reservation where id_user="+id_user;
            Statement st = new MyDB().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Reserv r = new Reserv();
                r.setId_reser(rs.getInt(1));
                r.setId_user(rs.getInt(1));
                r.setId_even(rs.getInt(1));
                r.setId_salle(rs.getInt(1));
                r.setDate(rs.getString("date"));
                myList.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return myList;}
    
        public List<Reserv> afficherReservevent(int id_user){
        List<Reserv> myList1 = new ArrayList<>();
        try {
            String requete3 = "SELECT date FROM reservation where id_user="+id_user+"& id_even=!NULL";
            Statement st = new MyDB().getConnection().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()){
                Reserv r = new Reserv();
                r.setId_reser(rs.getInt(1));
                r.setId_user(rs.getInt(1));
                r.setId_even(rs.getInt(1));
                r.setId_salle(rs.getInt(1));
                r.setDate(rs.getString("date"));
                myList1.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return myList1;
    
    }
    

}
