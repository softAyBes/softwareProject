package carpetcleaning;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class SendEmaill {
	
	public int email(String to, String msg) {
		
		
		
		final String username = "s12027881@stu.najah.edu";
        final String password = "ipzdbethgskjnioo";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("s12027881@stu.najah.edu"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to));
            message.setSubject("Notification Email");
            message.setText(msg);

            Transport.send(message);

            return 1;

        	} 
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
		
		
	}


