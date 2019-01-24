package com.teamfive.authentication.service;

import com.teamfive.authentication.entity.User;

public interface UserService {

    /**
     *
     *
     * @param user
     * @return
     */
    public User add(User user);

    /**
     *
     * @param emailId
     * @return
     */
    public User find(String emailId);
    public String login(String email,String password);
}
