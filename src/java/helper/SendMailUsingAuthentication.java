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

/**
 *
 * @author Armayau
 */
public class SendMailUsingAuthentication {
     private static final String SMTP_HOST_NAME = "smtp.gmail.com";
  private static final String SMTP_AUTH_USER = "umararmayau@gmail.com";
  private static final String SMTP_AUTH_PWD  = "Aishat@Zango3579";

  public static void main(String args[]) throws Exception
  {
String  rc  [] = {"umar_a_zango@yahoo.com", "bmadugu2006@yahoo.com"};
String msg ="message";
String sb="message";
String frm ="umararmayau@gmail.com";
SendMailUsingAuthentication tt = new SendMailUsingAuthentication();
tt.postMail(rc, sb, msg, frm);

  }

  public void postMail( String recipients[ ], String subject,String message , String from) throws MessagingException
  {
    try {
        boolean debug = false;

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(debug);

        Message msg = new MimeMessage(session);

        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);

        msg.setSubject(subject);

        msg.setContent(message, "text/plain");

        Transport.send(msg);

    } 
    catch (Throwable e) 
    {
        e.printStackTrace();
    }
 }
/**
* SimpleAuthenticator is used to do simple authentication
* when the SMTP server requires it.
*/
private class SMTPAuthenticator extends javax.mail.Authenticator
{
    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}
