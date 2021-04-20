package com.stackroute.JWTBasicDemo.service;

import com.stackroute.JWTBasicDemo.model.StudentUserDao;
import com.stackroute.JWTBasicDemo.model.UserDto;
import com.stackroute.JWTBasicDemo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StudentUserDao user = userDao.findByemail(email);
        if(user==null){
            throw new UsernameNotFoundException("User not found" + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
    }

    public StudentUserDao save(UserDto userDto){
        StudentUserDao newUser = new StudentUserDao();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

        newUser.setAge(userDto.getAge());
        newUser.setFirstname(userDto.getFirstname());
        newUser.setLastname(userDto.getLastname());
        newUser.setPhoneno(userDto.getPhoneno());
        newUser.setEmail(userDto.getEmail());

        return userDao.save(newUser);
    }
}
