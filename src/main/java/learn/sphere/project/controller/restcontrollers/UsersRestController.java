package learn.sphere.project.controller.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import learn.sphere.project.model.Account;
import learn.sphere.project.service.UsersService;

@Controller
@RequestMapping("/rest-api/user/v1")
public class UsersRestController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/register")
    public ResponseEntity<String> register_user(@RequestBody Account user) {
        if(usersService.save(user) != null){
            return new ResponseEntity<>("Lesson created successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("User creation failed", HttpStatus.BAD_REQUEST);
    }
}
