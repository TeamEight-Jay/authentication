package com.teamfive.authentication.service;

import com.teamfive.authentication.entity.User;
import com.teamfive.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

//    @Override
//    public User findByEmail(String emailId){
//        return userRepository.findOne(emailId);
//    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }
    @Override
    public User find(String emailId){
        return userRepository.findOne(emailId);
    }
    @Override
    public  String login(String emailId,String password){
        return ("successfully loggedin");
    }

}
