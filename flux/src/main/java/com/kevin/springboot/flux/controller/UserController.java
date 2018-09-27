package com.kevin.springboot.flux.controller;

import com.kevin.springboot.flux.domain.User;
import com.kevin.springboot.flux.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Web MVC
 * @Auther: liangxuekai
 * @Date: 18/9/27 14:46
 * @Description:
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/web/mvc/user/save")
    public Boolean save(@RequestBody User user){
        return userRepository.save(user);
    }
}
