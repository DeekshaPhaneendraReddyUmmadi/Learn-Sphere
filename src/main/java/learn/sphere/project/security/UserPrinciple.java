package learn.sphere.project.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import learn.sphere.project.model.Account;
import learn.sphere.project.util.constant.Role;

public class UserPrinciple implements UserDetails {

    @Autowired
    private Account user;

    public UserPrinciple(Account user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" +user.getRole()));
    }
    
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public Role getRoles() {
        return user.getRole();
    }
}
