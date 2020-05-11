package com.asama.shop.dao;

import java.util.List;

import com.asama.shop.entity.Product;

public interface ProductDAO {
    
    Product findById(Integer id);

    List<Product> findAll();

    Product create(Product Product);

    void update(Product Product);

    Product delete(Integer id);

    List<Product> findAllByCategoryId(Integer id);

    List<Product> findByIds(String ids);

    List<Product> findBySpecial(Integer id);
}
