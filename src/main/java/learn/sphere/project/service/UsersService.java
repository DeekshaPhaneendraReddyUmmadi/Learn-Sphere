package learn.sphere.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.Account;
import learn.sphere.project.repository.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Account save(Account user){
        Optional<Account> optionalAccount = usersRepository.findOneByEmailIgnoreCase(user.getEmail());
        if(optionalAccount.isPresent()){
            return null;
        }

        user.setPassword(encoder.encode(user.getPassword()));
        usersRepository.save(user);
        return user;
    }

    public Optional<Account> getDetailsByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public Account getByName(String name){
        return usersRepository.findByName(name);
    }
}
