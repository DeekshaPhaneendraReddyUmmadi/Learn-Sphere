package learn.sphere.project.controller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import learn.sphere.project.model.Account;

@Controller
public class UsersController {
    @GetMapping("/")
    public String home(){
        return "/home/index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "/home/login";
    }
    
    @GetMapping("/error")
    public String error(Model model) {
        return "/error";
    }

    @GetMapping("/register")
    public String register(Model model) {
        Account user = new Account();
        model.addAttribute("user", user);
        return "/home/registration";
    }
    
}
