package obsessed.repositories;

import org.springframework.data.repository.CrudRepository;

import obsessed.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

}
