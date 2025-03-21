package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.dto.UserDto;
import com.example.careerfyJobPortal.dto.UserloggingDto;

import java.util.List;

public interface UserService {
    public boolean registerUser(UserDto userDto) throws Exception;

    boolean loginUser(UserloggingDto userloggingDto);

    List<UserDto> getAllUsers();

    Long countUsers();
}
