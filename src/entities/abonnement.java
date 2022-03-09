/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

/**
 *
 * @author MSI
 */
public class abonnement {
   private int ab_id;
   private int ab_salle;
   private String ab_nom;
   private int ab_type;
   private int ab_prix;

    public abonnement() {
    }
    public abonnement(int ab_salle, String ab_nom, int ab_type, int ab_prix) {
        this.ab_salle = ab_salle;
        this.ab_nom = ab_nom;
        this.ab_type = ab_type;
        this.ab_prix = ab_prix;
    }

    public abonnement(int ab_id, int ab_salle, String ab_nom, int ab_type, int ab_prix) {
        this.ab_id = ab_id;
        this.ab_salle = ab_salle;
        this.ab_nom = ab_nom;
        this.ab_type = ab_type;
        this.ab_prix = ab_prix;
    }
     
    
   
    

    public void setab_Nom(String nom) {
        this.ab_nom = nom;
    }

    public String getab_Nom() {
        return ab_nom;
    }

    public int getAb_id() {
        return ab_id;
    }

    public int getAb_salle() {
        return ab_salle;
    }

    public String getAb_nom() {
        return ab_nom;
    }

    public void setAb_nom(String ab_nom) {
        this.ab_nom = ab_nom;
    }

    public int getAb_type() {
        return ab_type;
    }

    public void setAb_type(int ab_type) {
        this.ab_type = ab_type;
    }

   

    public int getAb_prix() {
        return ab_prix;
    }

    public void setAb_id(int ab_id) {
        this.ab_id = ab_id;
    }

    public void setAb_salle(int ab_salle) {
        this.ab_salle = ab_salle;
    }

   

    public void setAb_prix(int ab_prix) {
        this.ab_prix = ab_prix;
    }
    
    
    
}
