package learn.sphere.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import learn.sphere.project.model.Account;
import learn.sphere.project.service.UsersService;
import learn.sphere.project.util.constant.Role;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Override
    public void run(String... args) throws Exception {
        Account user1 = new Account("gali", "tap@gmail.com", "pass", Role.STUDENT);
        usersService.save(user1);

        Account user2 = new Account("gali1", "gali@gmail.com",  "pass", Role.TRAINER);
        usersService.save(user2);

        Account user3 = new Account("gali2", "air@gmail.com",  "pass", Role.ADMIN);
        usersService.save(user3);
    }

}
