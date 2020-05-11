package com.asama.shop.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class GmailConfig {

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setDefaultEncoding("utf-8");
        senderImpl.setHost("smtp.gmail.com");
        senderImpl.setPort(587);
        senderImpl.setUsername("tranhuuluong888@gmail.com");
        senderImpl.setPassword("gaugaugau8");
        
        Properties properties = senderImpl.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.debug", true);
        return senderImpl;
    }
}
