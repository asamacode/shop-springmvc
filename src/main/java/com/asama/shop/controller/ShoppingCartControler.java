package com.asama.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asama.shop.service.CartService;

@Controller
public class ShoppingCartControler {

    @Autowired
    CartService cartService;

    @ResponseBody
    @RequestMapping("/cart/add/{id}")
    public Object[] addToCart(Model model, @PathVariable("id") Integer id) {
        cartService.add(id);
        Object[] info = {cartService.getCount(), cartService.getAmount()}; 
        return info;
    }
    
    @ResponseBody
    @RequestMapping("/cart/remove/{id}")
    public Object[] removeItemCart(Model model, @PathVariable("id") Integer id) {
        cartService.remove(id);
        Object[] info = {cartService.getCount(), cartService.getAmount()}; 
        return info;
    }
    
    @ResponseBody
    @RequestMapping("/cart/update/{id}/{qty}")
    public Object[] changeQtyCart(Model model, @PathVariable("id") Integer id, @PathVariable("qty") Integer qty) {
        cartService.update(id, qty);
        Object[] info = {cartService.getCount(), cartService.getAmount()}; 
        return info;
    }
    
    @RequestMapping("/cart/view")
    public String viewCart(Model model) {
        return "cart/view";
    }
    
    @ResponseBody
    @RequestMapping("/cart/clear")
    public void clearCart() {
        cartService.clear();
    }

}
