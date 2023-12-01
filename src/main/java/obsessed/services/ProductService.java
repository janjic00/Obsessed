package obsessed.services;

import java.util.List;

import obsessed.entity.ProductEntity;

public interface ProductService {

	ProductEntity saveProduct(ProductEntity product);

	ProductEntity getProductById(Integer id);

	void deleteProductById(Integer id);

	List<ProductEntity> getAllProducts();

	public ProductEntity updateProduct(Integer id, ProductEntity updatedProduct);

	public ProductEntity createNewProduct(ProductEntity product);
}
