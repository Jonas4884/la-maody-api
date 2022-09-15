package com.hei.la_Maody.controller.Security;

import com.hei.la_Maody.model.User.User;
import com.hei.la_Maody.service.securityService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/user")
    public User addUser (@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/user/all")
    public List<User> getUser(){
        return userService.getUser();
    }
}
