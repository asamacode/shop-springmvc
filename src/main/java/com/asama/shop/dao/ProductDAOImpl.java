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
public class ProductDAOImpl implements ProductDAO {

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

    @Override
    public List<Product> findByIds(String ids) {
        String hql = "FROM Product p WHERE p.id IN (" + ids + ")";
        Session session = factory.getCurrentSession();

        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        List<Product> products = query.getResultList();

        return products;
    }

    @Override
    public List<Product> findBySpecial(Integer id) {
        Session session = factory.getCurrentSession();
        String hql = "FROM Product p";
        TypedQuery<Product> query = session.createQuery(hql, Product.class);

        switch (id) {
        case 0:
            // new
            hql = "FROM Product p ORDER BY p.productDate DESC";
            break;
        case 1:
            // hot sale
            hql = "FROM Product p ORDER BY size(p.orderDetails) DESC";
            break;
        case 2:
            // most viewed
            hql = "FROM Product p ORDER BY p.viewCount DESC";
            break;
        case 3:
            // discount
            hql = "FROM Product p ORDER BY p.discount DESC";
            break;
        case 4:
            // discount
            hql = "FROM Product p WHERE p.special=true";
            break;
        }
        query = session.createQuery(hql, Product.class);
        query.setMaxResults(12);
        List<Product> products = query.getResultList();
        return products;
    }

}
