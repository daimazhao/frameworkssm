package com.its.service;

import com.its.entity.Users;

public interface UserService {
    Users queryByUsername(String username);
}
