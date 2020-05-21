package com.asama.shop.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.Category;
import com.asama.shop.entity.Product;

@Transactional
@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    SessionFactory factory;
    
    @Override
    public Category findById(Integer id) {
        Session session = factory.getCurrentSession();
        
        Category category = session.find(Category.class, id);
        return category;
    }

    @Override
    public List<Category> findAll() {
        String hql = "FROM Category";
        Session session = factory.getCurrentSession();
        
        TypedQuery<Category> query = session.createQuery(hql, Category.class);
        List<Category> categories = query.getResultList();
        return categories;
    }

    @Override
    public Category create(Category category) {
        Session session = factory.getCurrentSession();
        session.save(category);
        return category;
    }

    @Override
    public void update(Category category) {
        Session session = factory.getCurrentSession();
        session.update(category);
    }

    @Override
    public Category delete(Integer id) {
        Session session = factory.getCurrentSession();
        Category category = session.find(Category.class, id);
        session.delete(category);
        return category;
    }

    @Override
    public List<Category> getRandoms() {
        String hql = "FROM Category c WHERE SIZE(c.products) >= 4";
        Session session = factory.getCurrentSession();
        
        TypedQuery<Category> query = session.createQuery(hql, Category.class);
        List<Category> categories = query.getResultList();
        Collections.shuffle(categories);
        categories = categories.subList(0, 4);
        categories.forEach(cat -> {
            List<Product> products = cat.getProducts();
            Collections.shuffle(products);
            products = products.subList(0, 4);
            cat.setProducts(products);
        });
        return categories;
    }

}
