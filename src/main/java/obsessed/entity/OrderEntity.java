package obsessed.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private UserEntity user;
	
	private String address;
	
    private String status; // Dodat atribut za praćenje statusa narudžbine

    private Date orderDate; // Dodat atribut za praćenje datuma narudžbine
    
    private String phoneNumber;
	
	// dodaj osatle atribute koji ipisuju narudzbinu ( status,datum)
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<OrderItemEntity> items = new ArrayList<>();
	
	
	

	



	public OrderEntity(Integer id, UserEntity user, String address, String status, Date orderDate, String phoneNumber,
			List<OrderItemEntity> items) {
		super();
		this.id = id;
		this.user = user;
		this.address = address;
		this.status = status;
		this.orderDate = orderDate;
		this.phoneNumber = phoneNumber;
		this.items = items;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public OrderEntity() {
		super();
	}
	
	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItemEntity> getItems() {
		return items;
	}

	public void setItems(List<OrderItemEntity> items) {
		this.items = items;
	}
	
	
}
