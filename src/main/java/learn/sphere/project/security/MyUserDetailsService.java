package learn.sphere.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.Users;
import learn.sphere.project.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByName(username);
        // System.out.println(user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(user);
    }
}
