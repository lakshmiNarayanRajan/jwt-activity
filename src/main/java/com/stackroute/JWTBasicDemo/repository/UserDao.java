package com.stackroute.JWTBasicDemo.repository;

import com.stackroute.JWTBasicDemo.model.StudentUserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<StudentUserDao, Integer> {
    StudentUserDao findByemail(String email);
    StudentUserDao getById(long id);
}
