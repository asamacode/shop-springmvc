package com.asama.shop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.Order;

@Transactional
@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    SessionFactory factory;
    
    @Override
    public Order findById(Integer id) {
        Session session = factory.getCurrentSession();
        
        Order Order = session.find(Order.class, id);
        return Order;
    }

    @Override
    public List<Order> findAll() {
        String hql = "FROM Order";
        Session session = factory.getCurrentSession();
        
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        List<Order> categories = query.getResultList();
        return categories;
    }

    @Override
    public Order create(Order Order) {
        Session session = factory.getCurrentSession();
        session.save(Order);
        return Order;
    }

    @Override
    public void update(Order Order) {
        Session session = factory.getCurrentSession();
        session.update(Order);
    }

    @Override
    public Order delete(Integer id) {
        Session session = factory.getCurrentSession();
        Order Order = session.find(Order.class, id);
        session.delete(Order);
        return Order;
    }

}
