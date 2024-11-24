package learn.sphere.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import jakarta.servlet.http.HttpServletRequest;


@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "/home/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/home/login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "/home/registration";
    }
    
    @GetMapping("/error")
    public String error(Model model) {
        return "/error";
    }
    
    // @RequestMapping("/error")
    // public ModelAndView handleError(HttpServletRequest request) {
    //     ModelAndView modelAndView = new ModelAndView("error"); // Name of the error view
    //     // You can add additional error attributes to the model if needed
    //     return modelAndView;
    // }
}
