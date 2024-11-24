package learn.sphere.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.Users;
import learn.sphere.project.repository.UsersRepository;
import learn.sphere.project.util.constant.Role;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users save(Users user){
        Optional<Users> optionalAccount = usersRepository.findOneByEmailIgnoreCase(user.getEmail());
        if(optionalAccount.isPresent()){
            return null;
        }
        
        if(user.getRole().toLowerCase().equals("student")){
            user.setRole(Role.STUDENT.getRole());
        }else if(user.getRole().toLowerCase().equals("trainer")){
            user.setRole(Role.TRAINER.getRole());
        }else if(user.getRole() == null){
            user.setRole(null);
        }

        user.setPassword(encoder.encode(user.getPassword()));
        usersRepository.save(user);
        return user;
    }

    public Optional<Users> getDetailsByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public Users getByName(String name){
        return usersRepository.findByName(name);
    }
}
