package com.asama.shop.dao;

import java.util.List;

import com.asama.shop.entity.Customer;
import com.asama.shop.entity.Order;
import com.asama.shop.entity.OrderDetail;
import com.asama.shop.entity.Product;

public interface OrderDAO {

    Order findById(Integer id);

    List<Order> findAll();

    Order create(Order Order);

    void update(Order Order);

    Order delete(Integer id);

    void create(Order order, List<OrderDetail> orderDetails);

    List<Order> findByUser(Customer user);

    List<Product> findAllItems(Customer user);
}
