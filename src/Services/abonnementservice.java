/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.abonnement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.datasource;

/**
 *
 * @author MSI
 */
public class abonnementservice  {
    
    
    private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

        Connection conn;
        PreparedStatement stee;

    public abonnementservice() {
         conn = datasource.getInstance().getCnx();
    }
    
    
    
    
        public void ajouterabonnement(abonnement e ) {
        String req = "insert into abonnement (Ab_id,ab_nom,ab_type,ab_prix,ab_salle) values (?,?,?,?,?)";
        
        
        //int ab_id, int ab_salle, String ab_nom, String ab_type, int ab_prix
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, e.getAb_id());
            pst.setString(2, e.getAb_nom());
            pst.setInt(3, e.getAb_type());
            pst.setInt(4, e.getAb_prix());
            pst.setInt(5, e.getAb_salle());
            pst.executeUpdate();
            System.out.println("Abo ajouté");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    
    
    

    public void insert(abonnement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<abonnement> readAll() {
       String req = "select * from abonnement";

        List<abonnement> abonnement=new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               abonnement e = new abonnement();
               e.setAb_id(rs.getInt("ab_id"));
               e.setab_Nom(rs.getString("ab_nom"));
               e.setAb_type(rs.getInt("ab_type"));
               e.setAb_prix(rs.getInt("ab_prix"));
               e.setAb_salle(rs.getInt("ab_salle"));
               abonnement.add(e);
               System.out.println(e.toString());
           }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); ;
        }
        
        return abonnement ;
    
    
    
    }
       
    

    public boolean modifier(abonnement t,int id) {
        boolean update= true;
        String query = "UPDATE abonnement SET 	ab_salle='"+t.getAb_salle()+"',"
                + " ab_nom ='"+t.getab_Nom()+"', ab_type='"+t.getAb_type()+"', ab_prix='"+t.getAb_prix()+"' "
                + "WHERE ab_id ='"+id+"'"; 
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("l'abonnement a été bien modifier");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            update = false;
        }
        return update;
    }

    public void supprimer(int id) {
        String query = "DELETE FROM abonnement WHERE Ab_id =?";   
        try {
            stee=conn.prepareStatement(query);
            stee.setInt(1,id);
            stee.executeUpdate();
            System.out.println("l'abonnement a été bien supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    public List<abonnement> rechercheAbonnement( String valeur){
        List<abonnement> abonnement = new ArrayList();
        String requete = null;
        try{
            requete = "SELECT * from abonnement where ab_id like '%" + valeur + "%' or ab_nom like '%" + valeur + "%' or ab_type like '%" + valeur + "%' or ab_prix like '%" + valeur + "%' or ab_salle like '%" + valeur + "%'";
            stee = conn.prepareStatement(requete);
            abonnement e;
            for(ResultSet rs = stee.executeQuery(requete); rs.next(); abonnement.add(e)){
               e = new abonnement();
               e.setAb_id(rs.getInt("ab_id"));
               e.setab_Nom(rs.getString("ab_nom"));
               e.setAb_type(rs.getInt("ab_type"));
               e.setAb_prix(rs.getInt("ab_prix"));
               e.setAb_salle(rs.getInt("ab_salle"));
             
               
           }
            } catch (SQLException ex) {
           System.out.println(ex.getMessage()); ;
        }
        
        return abonnement ;
        }
    }
    

