package com.asama.shop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.Category;

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

}
