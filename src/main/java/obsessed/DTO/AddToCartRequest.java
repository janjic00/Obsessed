package obsessed.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import obsessed.entity.CartEntity;
import obsessed.entity.ProductEntity;

public class AddToCartRequest {

    @JsonProperty("cart")
    private CartEntity cart;

    @JsonProperty("product")
    private ProductEntity product;

    @JsonProperty("quantity")
    private int quantity;

    public AddToCartRequest() {
        // Default konstruktor
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}