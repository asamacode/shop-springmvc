package com.asama.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.asama.shop.entity.Customer;

@Component
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("user");
        if (user == null) {
            //save client uri
            response.sendRedirect("/account/login?message=You not authorized !");
            return false;
        } else {
            if (user.getAdmin()) {
                return true;
            } else {
              //save client uri
                response.sendRedirect("/account/login?message=You not authorized !");
                return false;
            }
        }
    }
}
