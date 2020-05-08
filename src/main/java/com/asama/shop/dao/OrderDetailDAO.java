package com.asama.shop.dao;

import java.util.List;

import com.asama.shop.entity.OrderDetail;

public interface OrderDetailDAO {

 OrderDetail findById(Integer id);
    
    List<OrderDetail> findAll();
    
    OrderDetail create(OrderDetail OrderDetail);
    
    void update(OrderDetail OrderDetail);
    
    OrderDetail delete(Integer id);
}
