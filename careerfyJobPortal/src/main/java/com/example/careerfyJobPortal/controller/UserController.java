package com.example.careerfyJobPortal.controller;


import com.example.careerfyJobPortal.dto.UserDto;
import com.example.careerfyJobPortal.dto.UserloggingDto;
import com.example.careerfyJobPortal.service.UserService;
import com.example.careerfyJobPortal.utility.ResponseUtil;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
//@CrossOrigin(origins = "*")
@Validated
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseUtil registerUser(@RequestBody @Valid UserDto userDto) throws Exception {
        boolean registerResult = userService.registerUser(userDto);

        if (registerResult) {
            return new ResponseUtil(201, "USER REGISTERED", null);

        } else {
            return new ResponseUtil(500, "USER DOES NOT REGISTERED", null);

        }
    }

    @PostMapping("/login")
    public ResponseUtil loginUser(@RequestBody @Valid UserloggingDto userloggingDto) throws Exception {
        boolean loginResult = userService.loginUser(userloggingDto);

        if (loginResult) {
            return new ResponseUtil(201, "LOGIN SUCCESSFULLY", null);

        } else {
            return new ResponseUtil(500, "LOGIN FAILED", null);

        }


    }


    @GetMapping("getAll")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }




    @GetMapping("/totalUsers")
    public Long getTotalUsers() {
        return userService.countUsers();
    }

}
