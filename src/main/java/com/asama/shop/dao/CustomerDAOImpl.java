package com.asama.shop.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.asama.shop.entity.Customer;

@Transactional
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    SessionFactory factory;

    @Override
    public Customer findById(String id) {
        Session session = factory.getCurrentSession();

        Customer Customer = session.find(Customer.class, id);
        return Customer;
    }

    @Override
    public List<Customer> findAll() {
        String hql = "FROM Customer";
        Session session = factory.getCurrentSession();

        TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
        List<Customer> categories = query.getResultList();
        return categories;
    }

    @Override
    public Customer create(Customer Customer) {
        Session session = factory.getCurrentSession();
        session.save(Customer);
        return Customer;
    }

    @Override
    public void update(Customer customer) {
        Session session = factory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public Customer delete(String id) {
        Session session = factory.getCurrentSession();
        Customer customer = session.find(Customer.class, id);
        session.delete(customer);
        return customer;
    }
}
