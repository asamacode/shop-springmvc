package com.asama.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asama.shop.dao.ProductDAO;
import com.asama.shop.entity.Product;

@Controller
public class ProductController {
    
    @Autowired
    ProductDAO productDAO;
    
    @RequestMapping("/product/list-by-category/{id}")
    public String listByCategory(Model model, @PathVariable("id") Integer id) {
        List<Product> products = productDAO.findAllByCategoryId(id);
        model.addAttribute("listProduct", products);
        return "product/list";
    }
    
    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product product = productDAO.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }

}
