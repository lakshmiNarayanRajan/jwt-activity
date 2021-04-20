package com.stackroute.JWTBasicDemo.service;

import com.stackroute.JWTBasicDemo.model.DaoUser;
import com.stackroute.JWTBasicDemo.model.UserDto;
import com.stackroute.JWTBasicDemo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DaoUser user = userDao.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found" + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }

    public DaoUser save(UserDto userDto){
        DaoUser newUser = new DaoUser();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userDao.save(newUser);
    }
}
