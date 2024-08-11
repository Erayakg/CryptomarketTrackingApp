package com.crypto.base.controller;

import com.crypto.base.dto.RestResponse;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserDtoRes;
import com.crypto.base.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UserServiceImpl userService;
    @Autowired
    public UserController(BCryptPasswordEncoder passwordEncoder, UserServiceImpl userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse<SaveUserReq>> createUser(@RequestBody SaveUserReq saveUserReq) {

        userService.saveUser(saveUserReq);

        return new ResponseEntity<>(RestResponse.of(), HttpStatus.CREATED);
    }
    @PostMapping("/{id}/update")
    public ResponseEntity<RestResponse<SaveUserReq>> updateUser(@PathVariable Long id, @RequestBody SaveUserReq saveUserReq) {

        userService.updateUser(saveUserReq, id);

        return new ResponseEntity<>(RestResponse.empty(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<RestResponse<List<UserDtoRes>>> getUser() {
        
        return new ResponseEntity<>(RestResponse.of(userService.getAllUsers()), HttpStatus.OK);

    }
}
