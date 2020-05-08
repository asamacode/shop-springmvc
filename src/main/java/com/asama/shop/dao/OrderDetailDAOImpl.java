package com.asama.shop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.OrderDetail;

@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Autowired
    SessionFactory factory;
    
    @Override
    public OrderDetail findById(Integer id) {
        Session session = factory.getCurrentSession();
        
        OrderDetail OrderDetail = session.find(OrderDetail.class, id);
        return OrderDetail;
    }

    @Override
    public List<OrderDetail> findAll() {
        String hql = "FROM OrderDetail";
        Session session = factory.getCurrentSession();
        
        TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
        List<OrderDetail> categories = query.getResultList();
        return categories;
    }

    @Override
    public OrderDetail create(OrderDetail OrderDetail) {
        Session session = factory.getCurrentSession();
        session.save(OrderDetail);
        return OrderDetail;
    }

    @Override
    public void update(OrderDetail OrderDetail) {
        Session session = factory.getCurrentSession();
        session.update(OrderDetail);
    }

    @Override
    public OrderDetail delete(Integer id) {
        Session session = factory.getCurrentSession();
        OrderDetail OrderDetail = session.find(OrderDetail.class, id);
        session.delete(OrderDetail);
        return OrderDetail;
    }

}
