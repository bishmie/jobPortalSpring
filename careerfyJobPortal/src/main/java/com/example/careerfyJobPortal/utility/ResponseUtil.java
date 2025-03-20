package com.example.SpringBoot_LectureTime_Project.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {

    private int code;
    private String msg;
    private Object data;



}
