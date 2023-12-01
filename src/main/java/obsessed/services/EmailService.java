package obsessed.services;

public interface EmailService {
	void sendEmail(String to, String subject,String text);
    void sendOrderConfirmationEmail(String to, String subject, String orderDetails);
	void sendOrderDetailsToSeller(String to, String subject, String orderDetails);

}
