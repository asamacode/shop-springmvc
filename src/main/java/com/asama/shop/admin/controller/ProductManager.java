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

import com.asama.shop.dao.ProductDAO;
import com.asama.shop.entity.Product;

@Controller
public class ProductManager {
    
    @Autowired
    ProductDAO productDAO;
    
    @Autowired
    ServletContext app;

    @RequestMapping("/admin/product/index")
    public String index(Model model) {
        Product entity = new Product();
        List<Product> categories = productDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/product/index";
    }
    
    @RequestMapping("/admin/product/edit/{id}")
    public String edit(Model model, 
            @PathVariable("id") Integer id) {
        Product entity = productDAO.findById(id);
        List<Product> categories = productDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/product/index";
    }
    
    @RequestMapping("/admin/product/create")
    public String create(RedirectAttributes model,
            @ModelAttribute("entity") Product product,
            @RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
        if (file.isEmpty()) {
            product.setImage("user.png");
        } else {
            product.setImage(file.getOriginalFilename());
            String path = app.getRealPath("/resources/images/products/" + product.getImage());
            File f = new File(path);
            file.transferTo(f);
        }
        productDAO.create(product);
        model.addAttribute("message", "Thêm mới thành công");
        return "redirect:/admin/product/index";
    }
    
    @RequestMapping("/admin/product/update")
    public String update(RedirectAttributes model,
            @ModelAttribute("entity") Product product,
            @RequestParam("photo_file") MultipartFile file) throws IllegalStateException, IOException {
        if (!file.isEmpty()) {
            product.setImage(file.getOriginalFilename());
            String path = app.getRealPath("/resources/images/products/" + product.getImage());
            File f = new File(path);
            file.transferTo(f);
        }
        productDAO.update(product);
        model.addAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/admin/product/edit/" + product.getId();
    }
    
    @RequestMapping(value = {"/admin/product/delete", "/admin/product/delete/{id}"})
    public String delete(RedirectAttributes model,
            @RequestParam(value = "id", required = false) Integer id1, 
            @PathVariable(value = "id", required = false) Integer id2) {
        Integer id = (id1 != null) ? id1 : id2;
        productDAO.delete(id);
        model.addAttribute("message", "Xóa thành công");
        return "redirect:/admin/product/index";
    }
}
