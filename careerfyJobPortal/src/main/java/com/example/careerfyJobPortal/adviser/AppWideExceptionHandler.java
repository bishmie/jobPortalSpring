package com.example.careerfyJobPortal.adviser;


import com.example.careerfyJobPortal.utility.ResponseUtil;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseUtil exceptionHandler(Exception ex){
         return new ResponseUtil(500,"Internal Server Error",ex.getMessage());

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseUtil handleValidationException(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseUtil(400, "Validation Error: " + errors, null);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseUtil handleGlobalException(Exception ex) {
//        return new ResponseUtil(500, "Internal Server Error: " + ex.getMessage(), null);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseUtil methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
//     String msg =  ex.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(", "));
//     return  msg;
//    }




}








