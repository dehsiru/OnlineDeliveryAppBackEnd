package com.ds.order.service;

import com.ds.order.domain.Category;
import com.ds.order.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return this.categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return this.categoryRepository.save(category);
    }


}
