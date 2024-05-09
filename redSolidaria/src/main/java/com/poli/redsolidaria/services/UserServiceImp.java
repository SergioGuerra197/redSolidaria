package com.poli.redsolidaria.services;

import com.poli.redsolidaria.models.User;
import com.poli.redsolidaria.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;


    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("usuario o contraseña invalidos");
        }

        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRol());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(authority)
        );
        
    }

    
}
