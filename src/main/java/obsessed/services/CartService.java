package obsessed.services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import obsessed.entity.CartEntity;
import obsessed.entity.ProductEntity;

@Service
public class CartService {
	
	private final EmailService emailService;
	private static final String SELLER_EMAIL = "bojan.janjic.brains22@gmail.com";
	
	public CartService(EmailService emailService) {
		this.emailService = emailService;
	}
	  public void addProductToCart(CartEntity cart, ProductEntity product, int quantity) {
	        if (cart == null || product == null || quantity <= 0) {
	            throw new IllegalArgumentException("Invalid parameters for adding product to cart.");
	        }

	        cart.getCartItems().merge(product, quantity, Integer::sum);
	        
	        String orderDetails = "Detalji narudzbine: " + 
	        "Proizvod: " + product.getName() +
	        ",Kolicina: " + quantity + 
	        ", Ukupna cena: " + (quantity * product.getPrice());
	        
	        emailService.sendOrderConfirmationEmail(cart.getCustomerEmail(), "Potvrda narudzbine", orderDetails);
	        
	        emailService.sendOrderDetailsToSeller(SELLER_EMAIL, "Nova narudzbina", orderDetails);
	    }
	}

