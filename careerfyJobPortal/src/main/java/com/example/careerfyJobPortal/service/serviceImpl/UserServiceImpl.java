package com.example.careerfyJobPortal.service;

import com.example.careerfyJobPortal.adviser.AppWideExceptionHandler;
import com.example.careerfyJobPortal.dto.UserDto;
import com.example.careerfyJobPortal.dto.UserloggingDto;
import com.example.careerfyJobPortal.entity.User;
import com.example.careerfyJobPortal.repositry.UserRepositry;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public boolean registerUser(UserDto userDto) {

        Optional<User> optionalUser = userRepositry.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            return false;
        }

//        if (userRepositry.existsById(userDto.getId())) {
//            return false;
//        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        System.out.println("Raw Password: " + userDto.getPassword());

        User user =modelMapper.map(userDto, User.class);

        userRepositry.save(user);

        return true;

    }

    @Override
    public boolean loginUser(UserloggingDto userloggingDto) {
        Optional<User> optionalUser = userRepositry.findByEmail(userloggingDto.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Compare the raw password with the encrypted one in the database
            return passwordEncoder.matches(userloggingDto.getPassword(), user.getPassword());
        }
        return false; // User not found
    }
}
