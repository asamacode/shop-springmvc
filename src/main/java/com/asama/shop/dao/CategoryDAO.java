package com.asama.shop.dao;

import java.util.List;

import com.asama.shop.entity.Category;

public interface CategoryDAO {

    Category findById(Integer id);
    
    List<Category> findAll();
    
    Category create(Category category);
    
    void update(Category category);
    
    Category delete(Integer id);

    List<Category> getRandoms();
}
