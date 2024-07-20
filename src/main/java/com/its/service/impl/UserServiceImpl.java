package com.its.service.impl;

import com.its.entity.Users;
import com.its.mapper.UserMapper;
import com.its.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Users queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }

}
