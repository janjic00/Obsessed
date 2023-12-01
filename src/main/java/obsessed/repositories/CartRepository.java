package obsessed.repositories;

import org.springframework.data.repository.CrudRepository;

import obsessed.entity.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {

}
