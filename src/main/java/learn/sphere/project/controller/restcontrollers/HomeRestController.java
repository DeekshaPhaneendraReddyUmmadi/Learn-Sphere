// package learn.sphere.project.controller.restcontrollers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import learn.sphere.project.model.Account;
// import learn.sphere.project.service.UsersService;

// @RestController
// @RequestMapping("/api/user/v1")
// public class HomeRestController {

//     @Autowired
//     private UsersService usersService;

//     @PostMapping("/register")
//     public String register_user(@ModelAttribute Account user, BindingResult result) {
//         usersService.save(user);
//             return "redirect:/";
//     }
// }
