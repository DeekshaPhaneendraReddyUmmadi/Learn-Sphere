package learn.sphere.project.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import learn.sphere.project.model.Account;
import learn.sphere.project.service.UsersService;

@Controller
public class HomeController {

    @Autowired
    private UsersService usersService;

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

    @PostMapping("/register")
    public String register_user(@ModelAttribute Account user, BindingResult result) {
            usersService.save(user);
            return "redirect:/";
    }
    

    @GetMapping("/student")
    @PreAuthorize("isAuthenticated()")
    public String studentHome(Model model, Principal principal){
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                model.addAttribute( "account", account);
                return  "/student/studentHome";
        }else{
            return "redirect:/?error";
        }
    }
    
    @GetMapping("/trainer")
    @PreAuthorize("isAuthenticated()")
    public String  trainerHome(Model model, Principal principal){
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }

        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                System.out.println(account.toString());
                model.addAttribute( "account", account);
                return  "/trainer/trainerHome";
        }else{
            return "redirect:/error";
        }
    }
    
    @GetMapping("/adminHome")
    @PreAuthorize("isAuthenticated()")
    public String adminHome(Model model, Principal principal){
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                model.addAttribute( "account", account);
                return  "/admin/adminHome";
        }else{
            return "redirect:/?error";
        }
    }
    

    @GetMapping("/redirect")
    public String redirectBasedOnRole(Principal principal) {
        String redirectUrl = "/";
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
        if(optionalAccount.isPresent()) {
            Account user = optionalAccount.get();

            if (user != null) {
                switch (user.getRole()) {
                    case ADMIN:
                        redirectUrl = "/adminHome";
                        break;
                    case TRAINER:
                        redirectUrl = "/trainer";
                        break;
                    case STUDENT:
                        redirectUrl = "/student";
                        break;
                    default:
                        break;
                }
            }
        }
        return "redirect:" + redirectUrl;
    }
}
