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

import com.asama.shop.dao.CategoryDAO;
import com.asama.shop.entity.Category;

@Controller
public class CategoryManager {
    
    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("/admin/category/index")
    public String index(Model model) {
        Category entity = new Category();
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/category/index";
    }
    
    @RequestMapping("/admin/category/edit/{id}")
    public String edit(Model model, 
            @PathVariable("id") Integer id) {
        Category entity = categoryDAO.findById(id);
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("entity", entity);
        model.addAttribute("list", categories);
        return "admin/category/index";
    }
    
    @RequestMapping("/admin/category/create")
    public String create(RedirectAttributes model,
            @ModelAttribute("entity") Category category) {
        categoryDAO.create(category);
        model.addAttribute("message", "Thêm mới thành công");
        return "redirect:/admin/category/index";
    }
    
    @RequestMapping("/admin/category/update")
    public String update(RedirectAttributes model,
            @ModelAttribute("entity") Category category) {
        categoryDAO.update(category);
        model.addAttribute("message", "Chỉnh sửa thành công");
        return "redirect:/admin/category/edit/" + category.getId();
    }
    
    @RequestMapping(value = {"/admin/category/delete", "/admin/category/delete/{id}"})
    public String delete(RedirectAttributes model,
            @RequestParam(value = "id", required = false) Integer id1, 
            @PathVariable(value = "id", required = false) Integer id2) {
        Integer id = (id1 != null) ? id1 : id2;
        categoryDAO.delete(id);
        model.addAttribute("message", "Xóa thành công");
        return "redirect:/admin/category/index";
    }
}
