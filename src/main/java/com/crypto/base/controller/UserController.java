package com.crypto.base.controller;

import com.crypto.base.dto.*;
import com.crypto.base.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    private final UserServiceImpl userService;

    @Autowired
    public UserController(  UserServiceImpl userService) {
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
    @PostMapping("/createPortfolio/{id}")
    public ResponseEntity<RestResponse<UserDtoRes>> createPortfolio(@PathVariable Long id, @RequestBody PortfolioDtoReq portfolioDtoReq) {

        return new ResponseEntity<>(RestResponse.of(userService.CreatePortfolio(id,portfolioDtoReq )),HttpStatus.OK);

    }
    @PostMapping("/addPortfolio")
    public ResponseEntity<RestResponse<UserDtoRes>> addPortfolioReq(@RequestBody AddPortfolioReq  addPortfolioReq) {

        return new ResponseEntity<>
                (RestResponse.of(userService.addPortfolio
                        (addPortfolioReq.getUserId(), addPortfolioReq.getPortfolioId())), HttpStatus.OK);
    }

    @DeleteMapping("/removePortfolio")
    public ResponseEntity<RestResponse<String>> removePortfolioReq(@RequestBody AddPortfolioReq  addPortfolioReq) {
       userService.removePortfolio(addPortfolioReq.getUserId(), addPortfolioReq.getPortfolioId());
        return new ResponseEntity<>(RestResponse.empty(), HttpStatus.OK);
    }

}
