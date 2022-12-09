package com.saccossystemmanagement.controller;

import com.saccossystemmanagement.model.Category;
import com.saccossystemmanagement.payload.CategoryRequest;
import com.saccossystemmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> listResponseEntity(){
        List<Category> categoryList=categoryService.findCategoryList();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @PostMapping("/category/save")
    public ResponseEntity<Category> saveCategoryResponseEntity(@RequestBody Category category){
        return  new ResponseEntity<>(categoryService.saveCategory(category),HttpStatus.ACCEPTED);
    }
    @PutMapping("/category/update/{categoryID}")
    public ResponseEntity<Category> updateCategoryResponseEntity(@PathVariable("categoryID") Long categoryID, @RequestBody Category category){
         category.setId(categoryID);
        return  new ResponseEntity<>(categoryService.updateCategory(categoryID,category),HttpStatus.ACCEPTED);
    }
    @GetMapping("/category/find/{id}")
    public ResponseEntity<Category> findCategoryResponseEntity(@PathVariable("id") Long id){
        Category category=categoryService.findCategoryById(id);
        return  new ResponseEntity<>(category,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<?> deleteCategoryResponseEntity(@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
