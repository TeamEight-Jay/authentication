package com.teamfive.authentication.controller;

import com.teamfive.authentication.dto.CredentialsDto;
import com.teamfive.authentication.dto.ResponseDto;
import com.teamfive.authentication.dto.UserDto;
import com.teamfive.authentication.entity.User;
import com.teamfive.authentication.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController

public class SignInController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "auth/signin")
    public ResponseDto login(@RequestBody CredentialsDto credentialsDto){
        User userExists = userService.find(credentialsDto.getEmailId());
        System.out.println(userExists);
        if(userExists != null){
            if(userExists.getPassword().equals(credentialsDto.getPassword())) {
                return new ResponseDto("SUCCESS",credentialsDto.getEmailId());
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
