package com.asama.shop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asama.shop.dao.OrderDAO;
import com.asama.shop.dao.OrderDetailDAO;
import com.asama.shop.entity.Customer;
import com.asama.shop.entity.Order;
import com.asama.shop.entity.OrderDetail;
import com.asama.shop.entity.Product;
import com.asama.shop.service.CartService;

@Controller
public class OrderController {

    @Autowired
    HttpSession session;

    @Autowired
    CartService cartService;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @GetMapping("/order/items")
    public String items(Model model) {
        Customer user = (Customer) session.getAttribute("user");
        List<Product> products = orderDAO.findAllItems(user);
        model.addAttribute("listProduct", products);
        return "product/list";
    }

    @GetMapping("/order/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Order order = orderDAO.findById(id);

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(order.getId());
        model.addAttribute("details", orderDetails);
        model.addAttribute("order", order);
        return "order/detail";
    }

    @GetMapping("/order/list")
    public String orderList(Model model) {
        Customer user = (Customer) session.getAttribute("user");
        List<Order> orders = orderDAO.findByUser(user);
        model.addAttribute("orders", orders);
        return "order/list";
    }

    @RequestMapping("/order/checkout")
    public String showCheckout(@ModelAttribute("order") Order order) {
        Customer user = (Customer) session.getAttribute("user");
        order.setOrderDate(new Date());
        order.setCustomer(user);
        order.setAmount(cartService.getAmount());
        return "order/checkout";
    }

    @PostMapping("/order/checkout")
    public String checkout(Model model, @ModelAttribute("order") Order order) {
        Collection<Product> products = cartService.getItems();
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (Product p : products) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(p);
            orderDetail.setUnitPrice(p.getPrice());
            orderDetail.setQuantity(p.getQuantity());
            orderDetail.setDiscount(p.getDiscount());
            orderDetails.add(orderDetail);
        }

        orderDAO.create(order, orderDetails);
        cartService.clear();
        return "redirect:/order/list";
    }
}
