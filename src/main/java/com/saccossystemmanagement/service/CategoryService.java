package com.saccossystemmanagement.service;

import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.payload.CategoryRequest;
import com.saccossystemmanagement.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findCategoryList(){
        return categoryRepository.findAll();
    }
    public Category saveCategory(Category category){
        if(isCategoryPresent(category.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Sorry category  exist");
        }
        return  categoryRepository.save(category);
    }
    public Category findCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }
    public Category updateCategory(Long categoryId ,Category categoryRequest){
        Category category=categoryRepository.findById(categoryId).get();
        if (category==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Sorry category does not exist");
        }
        category.setId(categoryRequest.getId());
        category.setName(categoryRequest.getName());
        return categoryRepository.save(category);
    }
    public void deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
    }
    public Category findCategoryByName(String name){
        return categoryRepository.findCategoryByName(name);
    }
    public  boolean isCategoryPresent(String name){
        Category category=findCategoryByName(name);
        if (category!=null)
            return true;
        return false;
    }

}
