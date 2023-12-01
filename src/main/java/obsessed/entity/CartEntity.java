package obsessed.entity;
import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Dodatne informacije o korisniku
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerAddress;

    @ElementCollection
    @CollectionTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<ProductEntity, Integer> cartItems = new HashMap<>();

    // Dodatna polja kao što su adresa za dostavu, način plaćanja, itd., u zavisnosti od potreba vašeg projekta

    public CartEntity() {
        // Default konstruktor
    }
    
    

    public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Map<ProductEntity, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<ProductEntity, Integer> cartItems) {
        this.cartItems = cartItems;
    }
}