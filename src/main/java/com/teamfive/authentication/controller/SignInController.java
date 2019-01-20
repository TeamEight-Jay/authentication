package com.teamfive.authentication.controller;

import com.teamfive.authentication.dto.UserDto;
import com.teamfive.authentication.entity.User;
import com.teamfive.authentication.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignInController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@RequestParam String emailId,@RequestParam String password){
        User userExists = userService.find(emailId);
        System.out.println(userExists);
        if(userExists != null){
            if(userExists.getPassword().equals(password)) {

                return ("you are now logged in");
            }
            else{
                return ("passwrod is wrong");
            }
        }
        else{
            return ("Emaill not existed");
        }

    }

}
