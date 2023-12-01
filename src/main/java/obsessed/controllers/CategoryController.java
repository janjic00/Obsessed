package obsessed.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import obsessed.entity.CategoryEntity;
import obsessed.services.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    
    @Autowired
    private CategoryService categoryService;

    //RADI
    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity category) {
        categoryService.createNewCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    //RADI
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAllCategories(){
    	List<CategoryEntity> categories = categoryService.getAllCategories();
    	return ResponseEntity.ok(categories);
    }
    //RADI
    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Integer id){
    	CategoryEntity category = categoryService.getCategoryById(id);
    	if(category != null) {
    		return ResponseEntity.ok(category);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    //RADI
    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Integer id,@RequestBody CategoryEntity updatedCategory){
    	CategoryEntity existingCategory = categoryService.updateCategory(id, updatedCategory);
    	if(existingCategory != null) {
    		return ResponseEntity.ok(existingCategory);
    	}else {
    		return ResponseEntity.notFound().build();
    	}
    }
    //RADI
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id){
    	categoryService.deleteCategoryById(id);
    	return ResponseEntity.noContent().build();
    }
}
