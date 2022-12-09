package com.saccossystemmanagement.repository;

import com.saccossystemmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {
    Category findCategoryByName(String name);
    Optional<Category> findCategoryById(Long id);

}
