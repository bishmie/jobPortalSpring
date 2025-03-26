package com.example.careerfyJobPortal.controller;


import com.example.careerfyJobPortal.dto.AuthDTO;
import com.example.careerfyJobPortal.dto.ResponseDTO;
import com.example.careerfyJobPortal.dto.UserDto;
import com.example.careerfyJobPortal.dto.UserloggingDto;
import com.example.careerfyJobPortal.service.UserService;
import com.example.careerfyJobPortal.utility.JwtUtil;
import com.example.careerfyJobPortal.utility.ResponseUtil;
import com.example.careerfyJobPortal.utility.VarList;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Autowired
    private JwtUtil jwtUtil;

//    @PostMapping("/register")
//    public ResponseUtil registerUser(@RequestBody @Valid UserDto userDto) throws Exception {
//        boolean registerResult = userService.registerUser(userDto);
//
//        if (registerResult) {
//            return new ResponseUtil(201, "USER REGISTERED", null);
//
//        } else {
//            return new ResponseUtil(500, "USER DOES NOT REGISTERED", null);
//
//        }
//    }


//    @PostMapping("/login")
//    public ResponseUtil loginUser(@RequestBody @Valid UserloggingDto userloggingDto) throws Exception {
//        boolean loginResult = userService.loginUser(userloggingDto);
//
//        if (loginResult) {
//            return new ResponseUtil(201, "LOGIN SUCCESSFULLY", null);
//
//        } else {
//            return new ResponseUtil(500, "LOGIN FAILED", null);
//
//        }
//
//
//    }


    @GetMapping("getAll")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/totalUsers")
    public Long getTotalUsers() {
        return userService.countUsers();
    }


    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDto userDTO) {
        System.out.println("register");
        System.out.println(userDTO.getEmail());
        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getAccountType());
        try {
            int res = userService.addUser(userDTO);
            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", authDTO));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }


    @GetMapping("/getAllCandidates")
    public List<UserDto> getAllCandidates() {

        return userService.getAllCandidates();
    }

    @GetMapping("/getAllEmployers")
    public List<UserDto> getAllEmployers() {

        return userService.getAllEmployers();
    }


    @PostMapping(value = "/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseDTO> deactivateUser(@RequestBody UserDto userDTO) {
        userService.deactivateUser(userDTO);
        return ResponseEntity.ok(new ResponseDTO(VarList.OK, "User Deactivated", null));
    }

}
