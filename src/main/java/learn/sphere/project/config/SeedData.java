package learn.sphere.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import learn.sphere.project.model.Users;
import learn.sphere.project.service.UsersService;
import learn.sphere.project.util.constant.Role;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Override
    public void run(String... args) throws Exception {
        // Users user1 = Users.builder().username("gali").email("tap@gmail.com").password("pass").role(Role.STUDENT.getRole()).build();
        // Users user1 = new Users("gali", "tap@gmail.com", encoder.encode("pass"), Role.USER.toString());
        Users user1 = new Users("gali", "tap@gmail.com", "pass", Role.USER.toString());
        usersService.save(user1);
        // Users user2 = Users.builder().username("galisai").email("gali@gmail.com").password("pass").role(Role.STUDENT.getRole()).build();
        // Users user2 = new Users("gali1", "gali@gmail.com",  encoder.encode("pass"), Role.USER.toString());
        Users user2 = new Users("gali1", "gali@gmail.com",  "pass", Role.USER.toString());
        usersService.save(user2);
    }

}
