package com.its.mapper;

import com.its.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Users queryByUsername(String username);
}
