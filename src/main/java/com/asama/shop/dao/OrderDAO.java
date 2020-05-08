package com.asama.shop.dao;

import java.util.List;

import com.asama.shop.entity.Order;

public interface OrderDAO {

    Order findById(Integer id);

    List<Order> findAll();

    Order create(Order Order);

    void update(Order Order);

    Order delete(Integer id);
}
