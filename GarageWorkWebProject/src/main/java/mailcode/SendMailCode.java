package mailcode;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.incapp.dao.AdminDao;

public class SendMailCode {
	public static String sendMail(String remail,String sub,String body) {
		try {
			AdminDao db=new AdminDao();
			String adminDetails[]=db.getAdminDetails();
			String senderEmail=adminDetails[0];
			String senderPassword=adminDetails[1];
			
			Properties prop = new Properties();  
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");
			
			Session ses = Session.getInstance(prop,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(senderEmail,senderPassword);  
		      }  
		    });  
			
			Message message=new MimeMessage(ses);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, 
            		InternetAddress.parse(remail));
            message.setSubject(sub);
            message.setContent(body,"text/html" );
            
            Transport.send(message);
            return "Mail Send Success!";
			
		}catch (Exception e) {
			e.printStackTrace();
            return "Mail Send Failed!";
		}
	}
}
