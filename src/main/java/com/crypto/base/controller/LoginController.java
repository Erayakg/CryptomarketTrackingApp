package com.crypto.base.controller;

import com.crypto.base.dto.LoginFormdto;
import com.crypto.base.services.Impl.UserServiceImpl;
import com.crypto.base.util.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    @Autowired
    private final UserServiceImpl userService;
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthenticationManager manager;


    public LoginController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String authenticatedAndGenerate(@RequestBody LoginFormdto authRequest){
        Authentication authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }
        else {
            throw  new UsernameNotFoundException("invalid user");
        }
    }
}
