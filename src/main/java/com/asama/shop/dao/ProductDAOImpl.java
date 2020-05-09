package com.asama.shop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.Product;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    SessionFactory factory;
    
    @Override
    public Product findById(Integer id) {
        Session session = factory.getCurrentSession();
        
        Product Product = session.find(Product.class, id);
        return Product;
    }

    @Override
    public List<Product> findAll() {
        String hql = "FROM Product";
        Session session = factory.getCurrentSession();
        
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        List<Product> categories = query.getResultList();
        return categories;
    }

    @Override
    public Product create(Product Product) {
        Session session = factory.getCurrentSession();
        session.save(Product);
        return Product;
    }

    @Override
    public void update(Product Product) {
        Session session = factory.getCurrentSession();
        session.update(Product);
    }

    @Override
    public Product delete(Integer id) {
        Session session = factory.getCurrentSession();
        Product Product = session.find(Product.class, id);
        session.delete(Product);
        return Product;
    }

    @Override
    public List<Product> findAllByCategoryId(Integer id) {
        String hql = "FROM Product WHERE category_id = :id";
        Session session = factory.getCurrentSession();
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("id", id);
        List<Product> products = query.getResultList();
        return products;
    }

}
