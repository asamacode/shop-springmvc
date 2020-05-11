package com.asama.shop.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.asama.shop.dao.ProductDAO;
import com.asama.shop.entity.Product;

@SessionScope
@Service
public class CartService {
    Map<Integer, Product> map = new HashMap<Integer, Product>();
    
    @Autowired
    ProductDAO productDAO;

    public void add(Integer id) {
        Product product = map.get(id);
        
        if (product != null) {
           product.setQuantity(product.getQuantity() + 1);
        } else {
            product = productDAO.findById(id);
            product.setQuantity(1);
            map.put(id, product);
        }
    }

    public void remove(Integer id) {
        map.remove(id);
    }

    public void update(Integer id, int qty) {
        Product product = map.get(id);
        product.setQuantity(qty);
    }

    public void clear() {
        map.clear();
    }

    public int getCount() {
        Collection<Product> products = this.getItems();
        int count = 0;
        for (Product product : products) {
            count += product.getQuantity();
        }

        return count;
    }

    public double getAmount() {
        Collection<Product> products = this.getItems();
        double amount = 0;
        for (Product product : products) {
            amount += (product.getQuantity() * product.getPrice()) * (1 - product.getDiscount());
        }
        return amount;
    }

    public Collection<Product> getItems() {
        return map.values();
    }
}
