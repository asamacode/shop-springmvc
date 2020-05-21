package com.asama.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asama.shop.dao.CategoryDAO;
import com.asama.shop.dao.ProductDAO;
import com.asama.shop.entity.Category;
import com.asama.shop.entity.Product;

@Controller
public class HomeController {
    
    @Autowired
    CategoryDAO categoryDAO;
    
    @Autowired
    ProductDAO productDAO;

    @RequestMapping("home/index")
    public String index(Model model) {
        List<Category> categories = categoryDAO.getRandoms();
        model.addAttribute("rands", categories);
        List<Product> list = productDAO.findBySpecial(4);
        model.addAttribute("listProduct", list);
        return "home/index";
    }
    
    @RequestMapping("home/about")
    public String about() {
        return "home/about";
    }
    
    @RequestMapping("home/contact")
    public String contact() {
        return "home/contact";
    }
    
    @RequestMapping("home/services")
    public String services() {
        return "home/services";
    }
    
    @ResponseBody
    @RequestMapping("home/language")
    public void language() {
        
    }
}
