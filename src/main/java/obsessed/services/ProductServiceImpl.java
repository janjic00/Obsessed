package obsessed.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import obsessed.entity.ProductEntity;
import obsessed.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		
		return productRepository.save(product);
	}

	@Override
	public ProductEntity getProductById(Integer id) {
		return  productRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
		
	}

	@Override
	 @Transactional
	public List<ProductEntity> getAllProducts() {
		return (List<ProductEntity>)productRepository.findAll();
	}

	@Override
	public ProductEntity updateProduct(Integer id, ProductEntity updatedProduct) {
		ProductEntity existingProduct = productRepository.findById(id).orElse(null);
		if(existingProduct == null) {
			return null;
		}
		existingProduct.setCategory(updatedProduct.getCategory());
		existingProduct.setDescription(updatedProduct.getDescription());
		existingProduct.setImage(updatedProduct.getImage());
		existingProduct.setName(updatedProduct.getName());
		existingProduct.setPrice(updatedProduct.getPrice());
		existingProduct.setStock(updatedProduct.getStock());
		//existingProduct.setTags(updatedProduct.getTags());
		
		return productRepository.save(existingProduct);
	}

	@Override
	public ProductEntity createNewProduct(ProductEntity product) {
		ProductEntity pro = new ProductEntity();
		pro.setCategory(product.getCategory());
		pro.setDescription(product.getDescription());
		pro.setImage(product.getImage());
		pro.setName(product.getName());
		pro.setPrice(product.getPrice());
		pro.setStock(product.getStock());
		//pro.setTags(product.getTags()); // Postavlja tagove sa originalnog proizvoda na novi proizvod
		
		productRepository.save(pro);
		return new ProductEntity();
	}
	
}
