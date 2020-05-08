package com.asama.shop.dao;

import java.util.List;

import com.asama.shop.entity.Customer;

public interface CustomerDAO {

    Customer findById(String id);

    List<Customer> findAll();

    Customer create(Customer Customer);

    void update(Customer Customer);

    Customer delete(String id);
}
