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
    public ResponseEntity<RestResponse<UserDtoRes>> createUser(@RequestBody SaveUserReq saveUserReq) {

        UserDtoRes userDtoRes = userService.createUser(saveUserReq);

        return new ResponseEntity<>(RestResponse.of(userDtoRes), HttpStatus.CREATED);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<RestResponse<UserDtoRes>> updateUser(@PathVariable Long id, @RequestBody SaveUserReq saveUserReq) {

        UserDtoRes userDtoRes = userService.updateUser(saveUserReq, id);

        return new ResponseEntity<>(RestResponse.of(userDtoRes), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RestResponse<String>> deleteUser(@PathVariable Long id) {
         userService.deleteUser(id);
        return new ResponseEntity<>(RestResponse.empty(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<RestResponse<List<UserDtoRes>>> getAllUser() {
        
        return new ResponseEntity<>(RestResponse.of(userService.getAllUsers()), HttpStatus.OK);

    }
    @GetMapping("/getId/{id}")
    public ResponseEntity<RestResponse<UserDtoRes>> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(RestResponse.of(userService.getUserById(id)), HttpStatus.OK);
    }
}
