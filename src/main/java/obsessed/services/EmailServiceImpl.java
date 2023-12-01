package obsessed.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender emailSender;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender emailsender) {
		this.emailSender = emailsender;
	}
	
	@Override
	public void sendEmail(String to,String subject,String text) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text,true); //true oznacava da je HTML
			
			emailSender.send(message);
		  } catch (MailAuthenticationException e) {
			  System.out.println("Došlo je do greške: " + e.getMessage());
		        // Dodatna obrada greške
		    } catch (MailSendException e) {
		    	 System.out.println("Došlo je do greške: " + e.getMessage());
		        // Dodatna obrada greške
		    } catch (MailParseException e) {
		    	 System.out.println("Došlo je do greške: " + e.getMessage());
		        // Dodatna obrada greške
		    } catch (MailException e) {
		    	 System.out.println("Došlo je do greške: " + e.getMessage());
		        // Dodatna obrada greške
		    } catch (Exception e) {
		    	 System.out.println("Došlo je do greške: " + e.getMessage());
		        // Dodatna obrada greške
		    }
	}
	 @Override
	    public void sendOrderConfirmationEmail(String to, String subject, String orderDetails) {
	        String emailContent = "<p>" + orderDetails + "</p>";
	        sendEmail(to, subject, emailContent);
	    }

	    private void handleMailException(Exception e) {
	        System.out.println("Došlo je do greške prilikom slanja email-a: " + e.getMessage());
	        // Dodatna obrada greške, po potrebi
	    }
	
	    @Override
	    public void sendOrderDetailsToSeller(String to,String subject,String orderDetails) {
	    	sendEmail(to,subject,orderDetails);
	    }

}
