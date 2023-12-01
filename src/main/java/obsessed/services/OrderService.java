package obsessed.services;

import java.util.List;

import org.springframework.stereotype.Service;

import obsessed.entity.OrderEntity;
import obsessed.repositories.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final EmailService emailService;

    public OrderService(OrderRepository orderRepository, EmailService emailService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
    }

    public OrderEntity placeOrder(OrderEntity order) {
        // Obrada narudžbine...
        
        // Sačuvajte narudžbinu u bazi podataka
        OrderEntity savedOrder = orderRepository.save(order);
    
        // Slanje potvrde na e-mail
        String emailContent = "Vaša narudžbina je primljena. Detalji: " + savedOrder.toString();
        emailService.sendOrderConfirmationEmail(savedOrder.getUser().getEmail(), "Potvrda narudžbine", emailContent);
    
        return savedOrder;
    }

    public void sendOrderConfirmationEmail(String to, String subject, String orderDetails) {
        String emailContent = "<p>" + orderDetails + "</p>";
        emailService.sendEmail(to, subject, emailContent);
    }

    public List<OrderEntity> getAllOrders() {
        return (List<OrderEntity>) orderRepository.findAll();
    }

    public OrderEntity getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    // Dodajte ostale metode po potrebi

    public void updateOrder(Integer id, OrderEntity updatedOrder) {
        // Implementirajte ažuriranje narudžbine
    }

    public void deleteOrder(Integer id) {
        // Implementirajte brisanje narudžbine
    }
}