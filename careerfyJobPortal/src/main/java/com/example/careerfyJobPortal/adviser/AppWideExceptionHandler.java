package lk.ijse.z13_spring_boot.Advisor;


import lk.ijse.z13_spring_boot.util.ResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseUtil exceptionHandler(Exception ex){
         return new ResponseUtil(500,"Internal Server Error",ex.getMessage());

    }


}








