package obsessed.repositories;

import org.springframework.data.repository.CrudRepository;

import obsessed.entity.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {

}
