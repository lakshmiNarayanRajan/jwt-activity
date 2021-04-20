package com.stackroute.JWTBasicDemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private  String email;
    private String password;
    private String firstname;
    private String lastname;
    private int age;
    private String phoneno;

}
