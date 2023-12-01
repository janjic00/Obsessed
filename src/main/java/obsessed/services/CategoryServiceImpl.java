package obsessed.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import obsessed.entity.CategoryEntity;
import obsessed.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public CategoryEntity saveCategory(CategoryEntity category) {
		return categoryRepository.save(category);
	}

	@Override
	public CategoryEntity getCategoryById(Integer id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<CategoryEntity> getAllCategories() {
		return (List<CategoryEntity>) categoryRepository.findAll();
	}

	@Override
	public CategoryEntity updateCategory(Integer id, CategoryEntity updatedCategory) {
		CategoryEntity existingCategory = categoryRepository.findById(id).orElse(null);
		if(existingCategory == null) {
			return null;
		}
		existingCategory.setName(updatedCategory.getName());
		existingCategory.setDescription(updatedCategory.getDescription());
		existingCategory.setProducts(updatedCategory.getProducts());
		
		return categoryRepository.save(existingCategory);
	
	}

	@Override
	public CategoryEntity createNewCategory(CategoryEntity cate) {
		CategoryEntity category = new CategoryEntity();
		category.setName(cate.getName());
		category.setDescription(cate.getDescription());
		category.setProducts(cate.getProducts());
		
		categoryRepository.save(category);
		return new CategoryEntity();
	}

}
