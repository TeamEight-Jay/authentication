package com.teamfive.authentication.controller;

import com.teamfive.authentication.dto.ResponseDto;
import com.teamfive.authentication.dto.UserDto;
import com.teamfive.authentication.entity.User;
import com.teamfive.authentication.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
public class SignUpController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "auth/signup")
    public ResponseDto add(@RequestBody UserDto userDto) {
        // System.out.println(userDto);

        if(userDto==null) return new ResponseDto("FAILED","MALFORMED INPUTS #E1");
        if(userDto.getEmailId()==null) return new ResponseDto("FAILED","MALFORMED INPUTS #E2");
        if(userDto.getFirstName()==null) return new ResponseDto("FAILED","MALFORMED INPUTS #E3");
        if(userDto.getLastName()==null) return new ResponseDto("FAILED","MALFORMED INPUTS #E4");
        if(userDto.getPassword()==null) return new ResponseDto("FAILED","MALFORMED INPUTS #E5");
        if(userDto.getPhoneNumber()==null) return new ResponseDto("FAILED","MALFORMED INPUTS #E6");

        User userExists = userService.find(userDto.getEmailId());
        if(userExists != null){
            return new ResponseDto("FAILED","User already exists");
        }
        else{
            User user=new User();
            BeanUtils.copyProperties(userDto,user);
            User userCreated=userService.add(user);
            BeanUtils.copyProperties(userCreated, userDto);
            return new ResponseDto("SUCCESS","Registration Successful");
        }
    }

    @GetMapping(value = "auth/find")
    public UserDto find(@RequestParam String emailId){
        UserDto userDto=new UserDto();
        User user=userService.find(emailId);
        if(user==null) return null;
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }
}
