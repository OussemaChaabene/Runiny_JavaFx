/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EnvoyerEmail {
private String Email = "sami.abdelkarim@esprit.tn";
private String Password = "213JMT2561";
public void envoyer() {
// Etape 1 : Création de la session
Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.host","smtp.gmail.com");
props.put("mail.smtp.port","587");
props.put("mail.smtp.ssl.protocols", "TLSv1.2");
Session session = Session.getInstance(props,
new javax.mail.Authenticator() {
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(Email, Password);
}
});
try {
// Etape 2 : Création de l'objet Message
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress("sami.abdelkarim@esprit.tn"));
message.setRecipients(Message.RecipientType.TO,
InternetAddress.parse("samiabdlekrim98@gmail.com"));
message.setSubject("Test email");
message.setText("Bonjour, Monsieur veuiller confirmer votre compte!");
// Etape 3 : Envoyer le message
Transport.send(message);
System.out.println("Message_envoye");
} catch (MessagingException e) {
      System.out.println("error" + e.toString());
} }
//Etape 4 : Tester la méthode
public static void main(String[] args) {
EnvoyerEmail test = new EnvoyerEmail();
test.envoyer();
} }