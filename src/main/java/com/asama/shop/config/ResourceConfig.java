package com.asama.shop.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class ResourceConfig implements WebMvcConfigurer{
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
       interceptor.setParamName("lang");
       
       registry.addInterceptor(interceptor)
       .addPathPatterns("/home/language");
    }
    
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasenames("classpath:static/i18n/account", 
                "classpath:static/i18n/layout");
        ms.setDefaultEncoding("utf-8");
        return ms;
    }
    
    @Bean("localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver r = new CookieLocaleResolver();
        r.setCookiePath("/");
        r.setCookieMaxAge(2*24*60*60);
        r.setDefaultLocale(new Locale("en"));
        return r;
    }
}
