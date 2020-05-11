package com.asama.shop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.Customer;
import com.asama.shop.entity.Order;
import com.asama.shop.entity.OrderDetail;
import com.asama.shop.entity.Product;

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

    @Override
    public void create(Order order, List<OrderDetail> orderDetails) {
        Session session = factory.getCurrentSession();
        session.save(order);
        for (OrderDetail detail : orderDetails) {
            session.save(detail);
        }
    }

    @Override
    public List<Order> findByUser(Customer user) {
        String hql = "FROM Order o WHERE o.customer.id = :uid ORDER BY o.orderDate DESC";
        Session session = factory.getCurrentSession();
        
        TypedQuery<Order> query = session.createQuery(hql, Order.class);
        query.setParameter("uid", user.getId());
        List<Order> orders = query.getResultList();
        return orders;
    }

    @Override
    public List<Product> findAllItems(Customer user) {
        String hql = "SELECT DISTINCT d.product FROM OrderDetail d WHERE d.order.customer.id=:uid";
        Session session = factory.getCurrentSession();
        
        TypedQuery<Product> query = session.createQuery(hql, Product.class);
        query.setParameter("uid", user.getId());
        List<Product> products = query.getResultList();
        return products;
    }

}
