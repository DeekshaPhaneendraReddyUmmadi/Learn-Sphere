package learn.sphere.project.controller.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.sphere.project.model.Account;
import learn.sphere.project.service.UsersService;

@Controller
@RequestMapping("/api/user/v1")
public class UsersRestController {

    // @Autowired
    // private UsersService usersService;

    // @PostMapping("/register")
    // public String addUser(@Valid @RequestBody Users user){
    //     // if(au)
    //     if(usersService.save(user) != null){
    //         return "User added successfully.";
    //     }
    //     System.out.println(user);
    //     return "User record is present in the db.";
    // }


    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<String> register_user(@RequestBody Account user) {
        if(usersService.save(user) != null){
            // return "User added successfully.";
            return new ResponseEntity<>("Lesson created successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("User creation failed", HttpStatus.BAD_REQUEST);
        // return new ResponseEntity<>("Lesson created successfully", HttpStatus.CREATED);
        // return "redirect:/";
        // return "User record is present in the db.";
    }
}
