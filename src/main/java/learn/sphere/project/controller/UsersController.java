package learn.sphere.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import learn.sphere.project.model.Users;
import learn.sphere.project.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public String addUser(@Valid @RequestBody Users user){
        // if(au)
        if(usersService.save(user) != null){
            return "User added successfully.";
        }
        System.out.println(user);
        return "User record is present in the db.";
    }

    
}
