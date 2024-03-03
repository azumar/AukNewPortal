/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static org.jboss.logging.MDC.put;

/**
 *
 * @author Armayau
 */
public class App {
     public static void main(String[] args) {
        String from = "umararmayau@gmail.com";
        String to = "umar_a_zango@yahoo.com";

        Properties properties = createConfiguration();

        SmtpAuthenticator authentication = new SmtpAuthenticator();

        Session session = Session.getDefaultInstance(properties, authentication);

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(to));

            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

           // Send message
           Transport.send(message);

           System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
           mex.printStackTrace();
     }
 }

 private static Properties createConfiguration() {
    return new Properties() {
        {
            put("mail.smtp.auth", "true");
            put("mail.smtp.host", "smtp.gmail.com");
            put("mail.smtp.port", "587");
            put("mail.smtp.starttls.enable", "true");
        }
    };
 }

 private static class SmtpAuthenticator extends Authenticator {

        private String username = "umararmayau@gmail.com";
        private String password = "Aishat@Zango3579";

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }
}
