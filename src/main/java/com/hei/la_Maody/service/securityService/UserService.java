package com.hei.la_Maody.service.securityService;


import com.hei.la_Maody.model.User.User;
import com.hei.la_Maody.repository.Security.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    public User save(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }
}
