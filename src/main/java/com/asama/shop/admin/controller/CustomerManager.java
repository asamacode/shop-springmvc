package com.asama.shop.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asama.shop.dao.CustomerDAO;
import com.asama.shop.entity.Customer;

@Controller
public class CustomerManager {
    
    @Autowired
    CustomerDAO customerDAO;
    
    @Autowired
    ServletContext app;

    @RequestMapping("/admin/customer/index")
    public String index(Model model) {
        Customer entity = new Customer();
        List<Customer> categories = customerDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/customer/index";
    }
    
    @RequestMapping("/admin/customer/edit/{id}")
    public String edit(Model model, 
            @PathVariable("id") String id) {
        Customer entity = customerDAO.findById(id);
        List<Customer> categories = customerDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/customer/index";
    }
    
    @RequestMapping("/admin/customer/create")
    public String create(RedirectAttributes model,
            @ModelAttribute("entity") Customer customer,
            @RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
        if (file.isEmpty()) {
            customer.setPhoto("user.png");
        } else {
            customer.setPhoto(file.getOriginalFilename());
            String path = app.getRealPath("/resources/images/customers/" + customer.getPhoto());
            File f = new File(path);
            file.transferTo(f);
        }
        customerDAO.create(customer);
        model.addAttribute("message", "Thêm mới thành công");
        return "redirect:/admin/customer/index";
    }
    
    @RequestMapping("/admin/customer/update")
    public String update(RedirectAttributes model,
            @ModelAttribute("entity") Customer customer,
            @RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
        if (!file.isEmpty()) {
            customer.setPhoto(file.getOriginalFilename());
            String path = app.getRealPath("/resources/images/customers/" + customer.getPhoto());
            File f = new File(path);
            file.transferTo(f);
        }
        customerDAO.update(customer);
        model.addAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/admin/customer/edit/" + customer.getId();
    }
    
    @RequestMapping(value = {"/admin/customer/delete", "/admin/customer/delete/{id}"})
    public String delete(RedirectAttributes model,
            @RequestParam(value = "id", required = false) String id1, 
            @PathVariable(value = "id", required = false) String id2) {
        String id = (id1 != null) ? id1 : id2;
        customerDAO.delete(id);
        model.addAttribute("message", "Xóa thành công");
        return "redirect:/admin/customer/index";
    }
}
