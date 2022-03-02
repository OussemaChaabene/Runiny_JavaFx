/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runiny_javafx;

import Metier.PayementM;
import entities.payement;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author ASUS
 */
public class Runiny_javaFx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        payement p = new payement();
        p.setMontant(2000);
        PayementM pm=new PayementM();
        //pm.payment(p);
    }
}
