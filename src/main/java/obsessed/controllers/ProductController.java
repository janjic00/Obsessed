package obsessed.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import obsessed.entity.ProductEntity;
import obsessed.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//RADI
	@PostMapping
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product){
		ProductEntity createdProduct = productService.createNewProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	//RADI
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProductEntity>> getAllProducts(){
		List<ProductEntity> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	//RADI
	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProduct(@PathVariable Integer id){
		ProductEntity product = productService.getProductById(id);
		if(product != null) {
			return ResponseEntity.ok(product);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	//RADI 
	@PutMapping("/{id}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable Integer id, @RequestBody ProductEntity updatedProduct){
		ProductEntity updated = productService.updateProduct(id, updatedProduct);
		if(updated != null) {
			return ResponseEntity.ok(updated);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	//RADI
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
		productService.deleteProductById(id);
		return ResponseEntity.noContent().build();
	}
}
