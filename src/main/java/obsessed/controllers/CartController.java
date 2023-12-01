package obsessed.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import obsessed.DTO.AddToCartRequest;
import obsessed.services.CartService;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	   @PostMapping(consumes = "application/json", produces = "application/json")
	    public ResponseEntity<String> addProductToCart(@Valid @RequestBody AddToCartRequest request) {
	        try {
	            cartService.addProductToCart(request.getCart(), request.getProduct(), request.getQuantity());
	            return ResponseEntity.ok("Proizvod je dodat u korpu");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
}
