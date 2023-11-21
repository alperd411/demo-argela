package com.example.demoargela.Models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class SaveUserRequest {
    private  String Name;
    private  String Surname;
    private  String EmailAddr;
    private HashSet<Long> roleIds;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date DateOfBirt;

}
