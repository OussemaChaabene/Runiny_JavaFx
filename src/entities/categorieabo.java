/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author MSI
 */
public class categorieabo {
    private int id_categ;
    private String nom;
    

    public categorieabo() {
    }

    public categorieabo(int id_categ, String nom) {
        this.id_categ=id_categ;
        this.nom=nom;
    }

    public categorieabo(String nom) {
        this.nom=nom;
    }

    public int getId_categ() {
        return id_categ;
    }

    public void setId_categ(int id_categ) {
        this.id_categ = id_categ;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "categorieabo{" + "id_categ=" + id_categ + ", nom=" + nom + '}';
    }
}

   
