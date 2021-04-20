package com.stackroute.JWTBasicDemo.controller;

import com.stackroute.JWTBasicDemo.model.StudentUserDao;
import com.stackroute.JWTBasicDemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("student")
    public ResponseEntity<StudentUserDao> createNewUser(@RequestBody StudentUserDao studentUserDao){
        return new ResponseEntity<>(service.createNewUser(studentUserDao), HttpStatus.CREATED);
    }

    @GetMapping("students")
    public List<StudentUserDao> gerAllStudents(){
        return service.getAllStudents();
    }

    @DeleteMapping("student/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }

    @PutMapping("student")
    public ResponseEntity<StudentUserDao> updateEmployee(@RequestBody StudentUserDao student ){
        return new ResponseEntity<>(service.updateUser(student),HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public StudentUserDao getById(@PathVariable int id){
        return service.getById(id);
    }

    @GetMapping("students/{email}")
    public StudentUserDao getUserByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }

}
