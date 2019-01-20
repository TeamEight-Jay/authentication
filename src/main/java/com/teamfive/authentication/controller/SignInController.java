package com.teamfive.authentication.controller;

import com.teamfive.authentication.dto.CredentialsDto;
import com.teamfive.authentication.dto.ResponseDto;
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

    @PostMapping("auth/login")
    public ResponseDto login(@RequestBody CredentialsDto credentialsDto){
        User userExists = userService.find(credentialsDto.getEmail());
        System.out.println(userExists);
        if(userExists != null){
            if(userExists.getPassword().equals(credentialsDto.getPassword())) {
                return new ResponseDto("SUCESSS",credentialsDto.getEmail());
            }
            else{
                return new ResponseDto("FAILED","Email-ID or Password is incorrect");
            }
        }
        else{
            return new ResponseDto("FAILED","Email-ID or Password is incorrect");
        }

    }

}
