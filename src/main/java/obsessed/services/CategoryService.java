package obsessed.services;

import java.util.List;

import obsessed.entity.CategoryEntity;

public interface CategoryService {

	CategoryEntity saveCategory(CategoryEntity category);
	
	CategoryEntity getCategoryById(Integer id);
	void deleteCategoryById(Integer id);
	
	List<CategoryEntity> getAllCategories();
	
	public CategoryEntity updateCategory(Integer id,CategoryEntity updatedCategory);
	
	public CategoryEntity createNewCategory(CategoryEntity cate);
}
