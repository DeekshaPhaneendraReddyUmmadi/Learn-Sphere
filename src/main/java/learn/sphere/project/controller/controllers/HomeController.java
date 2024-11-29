// package learn.sphere.project.controller.controllers;

// import java.security.Principal;
// import java.util.Optional;

// // import org.springframework.security.access.prepost.PreAuthorize;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import java.util.List;

// // import java.security.Principal;
// // import java.util.Collection;

// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.core.Authentication;
// // import org.springframework.security.core.GrantedAuthority;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.stereotype.Controller;
// // import org.springframework.ui.Model;
// // import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.servlet.ModelAndView;
// // import org.springframework.web.bind.annotation.ModelAttribute;
// // import org.springframework.web.bind.annotation.PostMapping;

// import learn.sphere.project.model.Account;

// // import learn.sphere.project.model.Users;
// import learn.sphere.project.service.UsersService;

// // import jakarta.servlet.http.HttpServletRequest;


// // @Controller
// public class HomeController {

//     @Autowired
//     private UsersService usersService;


    

//     @GetMapping("/redirect")
//     public String redirectBasedOnRole(Principal principal) {
//         // Get the authenticated user's roles
//         // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         // System.out.println(principal.get);
//         String redirectUrl = "/";
//         String authUser = "email";
//         if(principal != null){
//             authUser =  principal.getName();
//         }
//         Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
//         if(optionalAccount.isPresent()) {
//             Account user = optionalAccount.get();
            
//             // if (user != null) {
//             //     List<String> roles = user.getRoles(); // Assuming getRoles() returns a List<String>
                
//             //     if (roles.contains("ROLE_ADMIN")) {
//             //         redirectUrl = "/adminHome";
//             //     } else if (roles.contains("ROLE_TRAINER")) {
//             //         redirectUrl = "/trainer";
//             //     } else if (roles.contains("ROLE_STUDENT")) {
//             //         redirectUrl = "/student";
//             //     } else {
//             //         redirectUrl = "/"; // Optional: Redirect to a default page if no roles match
//             //     }
//             // }
            
//             if (user != null) {
//                 switch (user.getRole()) {
//                     case ADMIN:
//                         redirectUrl = "/adminHome";
//                         break;
//                     case TRAINER:
//                         redirectUrl = "/trainer";
//                         break;
//                     case STUDENT:
//                         redirectUrl = "/student";
//                         break;
//                     default:
//                         break;
//                 }
//             }
//         }
//         return "redirect:" + redirectUrl;
//     }
// }
