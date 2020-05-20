package com.asama.shop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asama.shop.dao.OrderDAO;
import com.asama.shop.dao.OrderDetailDAO;
import com.asama.shop.entity.Order;
import com.asama.shop.entity.OrderDetail;

@Controller
public class OrderManager {
    
    @Autowired
    OrderDAO orderDAO;
    
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @RequestMapping("/admin/order/index")
    public String index(Model model) {
        Order entity = new Order();
        List<Order> categories = orderDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/order/index";
    }
    
    @RequestMapping("/admin/order/edit/{id}")
    public String edit(Model model, 
            @PathVariable("id") Integer id) {
        Order entity = orderDAO.findById(id);
        List<Order> categories = orderDAO.findAll();
        List<OrderDetail> details = orderDetailDAO.findByOrderId(entity.getId());
        model.addAttribute("details", details);
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/order/index";
    }
    
    @RequestMapping("/admin/order/create")
    public String create(RedirectAttributes model,
            @ModelAttribute("entity") Order order) {
        orderDAO.create(order);
        model.addAttribute("message", "Thêm mới thành công");
        return "redirect:/admin/order/index";
    }
    
    @RequestMapping("/admin/order/update")
    public String update(RedirectAttributes model,
            @ModelAttribute("entity") Order order) {
        orderDAO.update(order);
        model.addAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/admin/order/edit/" + order.getId();
    }
    
    @RequestMapping(value = {"/admin/order/delete", "/admin/order/delete/{id}"})
    public String delete(RedirectAttributes model,
            @RequestParam(value = "id", required = false) Integer id1, 
            @PathVariable(value = "id", required = false) Integer id2) {
        Integer id = (id1 != null) ? id1 : id2;
        orderDAO.delete(id);
        model.addAttribute("message", "Xóa thành công");
        return "redirect:/admin/order/index";
    }
}
