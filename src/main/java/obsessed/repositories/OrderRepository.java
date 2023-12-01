package obsessed.repositories;

import org.springframework.data.repository.CrudRepository;

import obsessed.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {

}
