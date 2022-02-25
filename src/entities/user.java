/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class user {
    
    int id;
    String login, mdp;
    Boolean status;

    public user() {
    }

    public user(int id, String login, String mdp, Boolean status) {
        this.id = id;
        this.login = login;
        this.mdp = mdp;
        this.status = status;
    }

    public user(String login, String mdp, Boolean status) {
        this.login = login;
        this.mdp = mdp;
        this.status = status;
    }

    public int getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", login=" + login + ", mdp=" + mdp + ", status=" + status + '}';
    }
    
    
    
}
