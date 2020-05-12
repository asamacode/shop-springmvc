package com.asama.shop.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.asama.shop.dao.CategoryDAO;
import com.asama.shop.entity.Category;

@Component
public class ShareInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    CategoryDAO categoryDAO;
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        List<Category> categories = categoryDAO.findAll();
        request.setAttribute("cates", categories);
    }
   
}
