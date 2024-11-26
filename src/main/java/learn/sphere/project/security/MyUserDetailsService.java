package learn.sphere.project.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.Account;
import learn.sphere.project.service.UsersService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = null;
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(username);
        if(optionalAccount.isPresent()) {
            user = optionalAccount.get();
        }
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(user);
    }
}
