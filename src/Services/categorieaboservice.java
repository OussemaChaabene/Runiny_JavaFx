/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.categorieabo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.datasource;

/**
 *
 * @author MSI
 */
public class categorieaboservice implements IService<categorieabo> {
     private Statement ste;
    private PreparedStatement pst;
    private ResultSet rs;

    private Connection conn;

    public categorieaboservice() {
         conn = datasource.getInstance().getCnx();
    }
    
        public void ajoutercategorie(categorieabo e ) {
        String req = "insert into catégorieabo (id_categ,nom) values (?,?)";
        
        
       
        try {
            pst = conn.prepareStatement(req);
            pst.setInt(1, e.getId_categ());
            pst.setString(2, e.getNom());
            pst.executeUpdate();
            System.out.println("categorie ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void insert(categorieabo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<String> readAllNom() {
        String req = "select nom from catégorieabo";

        List<String> categorie =new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               
               categorie.add(rs.getString("nom"));
               
           }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); ;
        }
        
        return categorie ;
    
    }

    @Override
    public List<categorieabo> readAll() {
        String req = "select * from catégorieabo";

        List<categorieabo> categorie =new ArrayList<>();
        try {
            ste = conn.createStatement();
           rs= ste.executeQuery(req);
           while(rs.next()){
               categorieabo e = new categorieabo();
               e.setId_categ(rs.getInt("id_categ"));
               e.setNom(rs.getString("nom"));
               categorie.add(e);
               System.out.println(e.toString());
           }

        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); ;
        }
        
        return categorie ;
    
    }

    @Override
    public boolean modifier(categorieabo t) {
        boolean update= true;
        String query = "UPDATE catégorieabo SET nom='"+"',"
                + "WHERE id_categ ='"+t.getId_categ()+"'"; 
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("la categorie a été bien modifier");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            update = false;
        }
        return update;
    }

    @Override
    public boolean supprimer(categorieabo t) {
         boolean suppression = true;
        try {
            String query = "DELETE FROM catégorieabo WHERE id_categ ='"+t.getId_categ()+"'";     
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            System.out.println("la caegorie a été bien supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            suppression = false;
        }   
        return suppression;
    }
    public int getId(String valeur) throws SQLException{
        int id=0;
        ResultSet rs = null;
        String sql="SELECT id_categ from catégorieabo where nom ='"+valeur+"'";
        Statement ste = conn.createStatement();
        rs=ste.executeQuery(sql);
        while(rs.next()){
            id = rs.getInt("id_categ");
        }
        return id ;
        
    }
    }

    
    

