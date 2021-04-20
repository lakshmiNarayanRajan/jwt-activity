package com.stackroute.JWTBasicDemo.controller;


import com.stackroute.JWTBasicDemo.config.JwtTokenUtil;
import com.stackroute.JWTBasicDemo.model.JwtRequest;
import com.stackroute.JWTBasicDemo.model.JwtResponse;
import com.stackroute.JWTBasicDemo.model.UserDto;
import com.stackroute.JWTBasicDemo.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception{
                 authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
                 final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
                 final String token = jwtTokenUtil.generateToken(userDetails);
                 return ResponseEntity.ok(new JwtResponse(token));

    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception{
        return ResponseEntity.ok(jwtUserDetailsService.save(user));
    }


    private void  authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("User Disabled", e);
        }catch (BadCredentialsException e){
            throw new Exception("Invalid Credentails",e);
        }
    }


}
