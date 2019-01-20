package com.teamfive.authentication.service;

import com.teamfive.authentication.entity.User;

public interface UserService {
    public User add(User user);
    public User find(String emailId);
    public String login(String email,String password);
}
