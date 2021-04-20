package com.stackroute.JWTBasicDemo.service;

import com.stackroute.JWTBasicDemo.model.StudentUserDao;
import com.stackroute.JWTBasicDemo.repository.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao repository;


    @Override
    public List<StudentUserDao> getAllStudents() {
        return (List<StudentUserDao>) repository.findAll();
    }

    @Override
    public StudentUserDao getById(long id) {
        return repository.getById(id);
    }

    @Override
    public StudentUserDao createNewUser(StudentUserDao student) {
        return repository.save(student);
    }

    @Override
    public void deleteUser(long id) {
        repository.delete(repository.getById(id));
    }

    @Override
    public StudentUserDao updateUser(StudentUserDao studentUserDao) {
        return repository.save(studentUserDao);
    }

    @Override
    public StudentUserDao findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
