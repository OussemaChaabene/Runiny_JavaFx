/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

/**
 *
 * @author ACER EXTENSA 15
 */
public class User {
    private int id_user;
    private String Nom , Prenom ,Adress, Login , Password,Role,date_naiss;

    public User(int id_user, String Nom, String Prenom, String Adress, String Login, String Password, String Role, String date_naiss) {
        this.id_user = id_user;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adress = Adress;
        this.Login = Login;
        this.Password = Password;
        this.Role = Role;
        this.date_naiss = date_naiss;
    }

    public User(String Nom, String Prenom, String Adress, String Login, String Password, String Role, String date_naiss) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adress = Adress;
        this.Login = Login;
        this.Password = Password;
        this.Role = Role;
        this.date_naiss = date_naiss;
    }

    public User() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        this.date_naiss = date_naiss;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adress=" + Adress + ", Login=" + Login + ", Password=" + Password + ", Role=" + Role + ", date_naiss=" + date_naiss + '}';
    }

    

    

   
    
    

   
    
}
