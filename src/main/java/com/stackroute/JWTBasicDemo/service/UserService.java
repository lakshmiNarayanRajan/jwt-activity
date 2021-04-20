package com.stackroute.JWTBasicDemo.service;

import com.stackroute.JWTBasicDemo.model.StudentUserDao;

import java.util.List;

public interface UserService {
    List<StudentUserDao> getAllStudents();
    StudentUserDao getById(long id);
    StudentUserDao createNewUser(StudentUserDao student);
    void deleteUser(long id);
    StudentUserDao updateUser(StudentUserDao studentUserDao);
    StudentUserDao findByemail(String email);
}
