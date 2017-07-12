package com.lwf.springboot.service;

import com.lwf.springboot.model.User;

import java.util.List;

/**
 * Created by lwf on 2017/3/15.
 */
public interface UserService {

    List<User> getAllUser();

    User getUserByPhoneOrEmail(String emailOrPhone, Short state);

    User getUserById(Long userId);
}
