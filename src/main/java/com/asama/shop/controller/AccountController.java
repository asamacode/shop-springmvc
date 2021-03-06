package com.asama.shop.controller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asama.shop.bean.MailInfo;
import com.asama.shop.dao.CustomerDAO;
import com.asama.shop.entity.Customer;
import com.asama.shop.service.CookieService;
import com.asama.shop.service.MailService;

@Controller
public class AccountController {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    HttpSession httpSession;

    @Autowired
    CookieService cookieService;

    @Autowired
    MailService mailService;

    @Autowired
    ServletContext app;

    @Autowired
    HttpServletRequest request;

    @GetMapping("/account/edit")
    public String edit(Model model) {
        Customer user = (Customer) httpSession.getAttribute("user");
        model.addAttribute("form", user);
        return "account/edit";
    }
    
    @PostMapping("/account/edit")
    public String edit(Model model, @ModelAttribute("form") Customer user,
            @RequestParam("photo_file") MultipartFile file)
            throws IllegalStateException, IOException, MessagingException {
        // upload file image
        if (!file.isEmpty()) {
            String dir = app.getRealPath("/resources/images/customers");
            File f = new File(dir, file.getOriginalFilename());
            file.transferTo(f);
            user.setPhoto(f.getName());
        }
        
        customerDAO.update(user);
        httpSession.setAttribute("user", user);
        model.addAttribute("message", "Update account info successfully !");
        return "account/edit";
    }
    @GetMapping("/account/change")
    public String changePass(Model model) {
        return "account/change";
    }

    @PostMapping("/account/change")
    public String changePass(Model model, @RequestParam("id") String id, @RequestParam("password") String password,
            @RequestParam("pw1") String pw1, @RequestParam("pw2") String pw2) {
        if (pw1.equals(pw2)) {
            model.addAttribute("message", "Confirm password is not match");
        } else {
            Customer user = customerDAO.findById(id);
            if (user == null) {
                model.addAttribute("message", "Invalid username");
            } else if (!password.equals(user.getPassword())) {
                model.addAttribute("message", "Invalid password");
            } else {
                user.setPassword(pw1);
                customerDAO.update(user);
                model.addAttribute("message", "Password change succesfully !");
            }
        }
        return "redirect:/account/login";
    }

    @GetMapping("/account/forget")
    public String forget(Model model) {
        return "account/forget";
    }

    @PostMapping("/account/forget")
    public String forget(Model model, @RequestParam("id") String id, @RequestParam("email") String email)
            throws MessagingException {
        Customer user = customerDAO.findById(id);
        if (user == null) {
            model.addAttribute("message", "Invalid username !");
        } else if (!email.equals(user.getEmail())) {
            model.addAttribute("message", "Invalid email !");
        } else {
            model.addAttribute("message", "Your password was send to your inbox !");

            String from = "tranhuuluong888@gmail.com";
            String to = user.getEmail();
            String subject = "Your Password - A SaMa Web";
            String body = "Mật khẩu tài khoản của bạn tại A SaMa Web là " + "<br><b>" + user.getPassword() + "</b>";
            MailInfo mailInfo = new MailInfo(from, to, subject, body);
            mailService.send(mailInfo);
        }
        return "account/forget";
    }

    @GetMapping("/account/login")
    public String login(Model model) {
        Cookie cookie_id = cookieService.read("userid");
        Cookie cookie_pass = cookieService.read("password");
        if (cookie_id != null && cookie_pass != null) {
            model.addAttribute("uid", cookie_id.getValue());
            model.addAttribute("upw", cookie_pass.getValue());
        }
        return "account/login";
    }

    @PostMapping("/account/login")
    public String login(Model model, @RequestParam("id") String id, @RequestParam("password") String password,
            @RequestParam(name = "rm", defaultValue = "false") boolean rm) {

        Customer customer = customerDAO.findById(id);
        if (customer == null) {
            model.addAttribute("message", "Invalid username !");
        } else if (!password.equals(customer.getPassword())) {
            model.addAttribute("message", "Invalid password !");
        } else if (!customer.getActived()) {
            model.addAttribute("message", "Account is inactived !");
        } else {
            model.addAttribute("message", "Login successfully !");
            httpSession.setAttribute("user", customer);
            // remember acc check
            if (rm) {
                cookieService.create("userid", id, 30);
                cookieService.create("password", password, 30);
            } else {
                cookieService.delete("userid");
                cookieService.delete("password");
            }
            
            //back to url
            String backUrl = (String) httpSession.getAttribute("back-url");
            if (backUrl != null) {
                return "redirect:"+backUrl;
            }
        }
        return "account/login";
    }

    @RequestMapping("/account/logout")
    public String logout(Model model) {
        httpSession.removeAttribute("user");
        return "redirect:/home/index";
    }

    @GetMapping("/account/register")
    public String register(Model model) {
        Customer customer = new Customer();
        model.addAttribute("form", customer);
        return "account/register";
    }

    @PostMapping("/account/register")
    public String register(Model model,@Validated @ModelAttribute("form") Customer user,
            BindingResult errors,
            @RequestParam("photo_file") MultipartFile file)
            throws IllegalStateException, IOException, MessagingException {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Please fix some following errors !");
            return "account/register";
        } else {
            Customer user2 = customerDAO.findById(user.getId());
            if (user2 != null) {
                model.addAttribute("message", "Username is in used !");
                return "account/register";  
            }
        }
        
        // upload file image
        if (file.isEmpty()) {
            user.setPhoto("user.png");
        } else {
            String dir = app.getRealPath("/resources/images/customers");
            File f = new File(dir, file.getOriginalFilename());
            file.transferTo(f);
            user.setPhoto(f.getName());
        }
        user.setActived(false);
        user.setAdmin(false);
        customerDAO.create(user);
        model.addAttribute("message", "Register successfully ! Please check your email");

        String from = "tranhuuluong888@gmail.com";
        String to = user.getEmail();
        String subject = "Welcome to A SaMa Web";
        String url = request.getRequestURI().toString().replace("register", "/active/" + user.getId());
        String body = "Vui lòng kích hoạt tài khoản của bạn tại A SaMa Web " + "<br>Click <a href='" + url
                + "'>Active</a>";
        MailInfo mailInfo = new MailInfo(from, to, subject, body);
        mailService.send(mailInfo);
        return "account/register";
    }

    @RequestMapping("/account/active/{id}")
    public String active(Model model, @PathVariable("id") String id) {
        Customer user = customerDAO.findById(id);
        user.setActived(true);
        customerDAO.update(user);
        return "redirect:/account/login";
    }
}
