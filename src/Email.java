import javax.mail.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class Email {
	
	public Email(String emailid, String otp) 
	{

    String host = "smtp.gmail.com";
    String user = "amanjainn23@gmail.com";
    String pass = "Afewwordshurtalot";

        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.user", user);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");

        Session session=Session.getInstance(prop,
        		new javax.mail.Authenticator()
        		{
        			protected PasswordAuthentication getPasswordAuthentication(){
        				return new PasswordAuthentication(user,pass);        			}
        		}
        		);

        try
        {
        	Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress("amanjainn23@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));
            message.setSubject("One Time Password");
            message.setText("Your One Time Password(OTP) is "+otp);
            Transport.send(message); 
            //The above line has a warning message
            //"The static method send(Message, Address[]) from the type Transport should be accessed in a static way" 
        }
        catch (AddressException e) {e.printStackTrace();}
        catch (MessagingException e) {e.printStackTrace();}
    }
	
	
	public Email(String em, String fname, String lname, String email, String mobile, String phone, String address ) 
	{

    String host = "smtp.gmail.com";
    String user = "amanjainn23@gmail.com";
    String pass = "Afewwordshurtalot";

        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.user", user);
        prop.put("mail.smtp.password", pass);
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");

        Session session=Session.getInstance(prop,
        		new javax.mail.Authenticator()
        		{
        			protected PasswordAuthentication getPasswordAuthentication(){
        				return new PasswordAuthentication(user,pass);        			}
        		}
        		);

        try
        {
        	Message message=new MimeMessage(session);
            message.setFrom(new InternetAddress("amanjainn23@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(em));
            message.setSubject("Contact Details");
            message.setText("Here are the contact details that you requested \n"+"First Name : "+fname+"\n"+"Last Name : "+lname+"\n"+"Email : "+email+"\n"+"Mobile : "+mobile+"\n"+"Phone : "+phone+"\n"+"Address : "+address);
            Transport.send(message); 
            new Send().messageSent();
        }
        catch (AddressException e) {e.printStackTrace();}
        catch (MessagingException e) {e.printStackTrace();}
    }

}