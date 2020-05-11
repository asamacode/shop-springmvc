package com.asama.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.asama.shop.interceptor.AuthorizeInterceptor;
import com.asama.shop.interceptor.ShareInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

    @Autowired
    ShareInterceptor shareInterceptor;
    
    @Autowired
    AuthorizeInterceptor authorizeInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(shareInterceptor)
        .addPathPatterns("/**");
        registry.addInterceptor(authorizeInterceptor)
        .addPathPatterns("/account/change", "/account/logout", "/account/edit", "/order/**");
    }
}
