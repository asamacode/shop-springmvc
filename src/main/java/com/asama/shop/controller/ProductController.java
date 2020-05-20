package com.asama.shop.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asama.shop.bean.MailInfo;
import com.asama.shop.common.Constants;
import com.asama.shop.dao.ProductDAO;
import com.asama.shop.entity.Product;
import com.asama.shop.service.CookieService;
import com.asama.shop.service.MailService;

@Controller
public class ProductController {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CookieService cookieService;

    @Autowired
    MailService mailService;

    @RequestMapping("/product/list-by-category/{id}")
    public String listByCategory(Model model, @PathVariable("id") Integer id) {
        List<Product> products = productDAO.findAllByCategoryId(id);
        model.addAttribute("listProduct", products);
        return "product/list";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product product = productDAO.findById(id);
        // increase product view count
        if (product.getViewCount() == null) {
            product.setViewCount(1);
        } else {
            product.setViewCount(product.getViewCount() + 1);
        }
        productDAO.update(product);
        // load and add favorite product
        List<Product> products = productDAO.findAllByCategoryId(product.getCategory().getId());
        Cookie cookie = cookieService.read(Constants.CK_FAV);

        if (cookie != null) {
            String ids = cookie.getValue();
            List<Product> fav_products = productDAO.findByIds(ids);
            model.addAttribute("listFav", fav_products);
        }
        // load and add viewed product
        Cookie cookie_view = cookieService.read(Constants.CK_VIEWED);
        String value = id.toString();
        if (cookie_view != null) {
            String ids = cookie_view.getValue();
            List<Product> viewed_products = productDAO.findByIds(ids);
            model.addAttribute("listViewed", viewed_products);
            // add current product to viewed
            value = cookie_view.getValue();
            if (!value.contains(id.toString())) {
                value += "," + id.toString();
            }
        }

        cookieService.create(Constants.CK_VIEWED, value, 10);

        model.addAttribute("product", product);
        model.addAttribute("listProduct", products);
        return "product/detail";
    }

    @ResponseBody
    @RequestMapping("/product/add-to-fav/{id}")
    public Boolean addToFav(Model model, @PathVariable("id") Integer id) {
        Cookie cookie = cookieService.read(Constants.CK_FAV);
        String value = id.toString();
        if (cookie != null) {
            value = cookie.getValue();
            if (!value.contains(id.toString())) {
                value += "," + id.toString();
            } else {
                return false;
            }
        }
        cookieService.create(Constants.CK_FAV, value, 30);
        return true;
    }

    @RequestMapping("/product/list-by-special/{id}")
    public String listBySpecial(Model model, @PathVariable("id") Integer id) {
        List<Product> products = productDAO.findBySpecial(id);
        model.addAttribute("listProduct", products);
        return "product/list";
    }

    @ResponseBody
    @RequestMapping("/product/send-to-friend")
    public boolean sendToFriend(Model model, MailInfo info, HttpServletRequest req) {
        String subject = "Sản phẩm này hay nè !";
        info.setSubject(subject);
        try {
            String id = req.getParameter("id");
            String link = req.getRequestURL().toString().replace("send-to-friend", "detail/"+id);
            info.setBody(info.getBody() + "<hr><a href='"+link+"'>Xem chi tiết...</a> <br> A SaMa Web");
            mailService.send(info);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}
