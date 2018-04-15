package org.dtr.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;

public class SendEmail
{
  public SendEmail() {}
  
  public static void sendEmail(String... args)
  {
   final String username = "testingdavid88@gmail.com";
   final String password = "123456789@@";
    
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
      });
    




    try
    {
      Message message = new javax.mail.internet.MimeMessage(session);
      message.setFrom(new InternetAddress("testingdavid88@gmail.com"));
      message.setRecipients(javax.mail.Message.RecipientType.TO, 
        InternetAddress.parse(args[0]));
      message.setSubject("Task status");
      message.setText("Dear " + args[1] + " " + args[2] + " has been completed .Thank you for using our service.");
      
      javax.mail.Transport.send(message);
      
      System.out.println("Done");


    }
    catch (MessagingException e)
    {

      System.out.println("Username or Password are incorrect ... exiting !");
    }
  }
  
  /*public static void main(String[] args) {
	
	  sendEmail("rubandavid88@gmail.com","Ruban"," amazon s");
	  
	  
}*/
  
  
}