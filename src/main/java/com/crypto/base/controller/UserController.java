package com.crypto.base.controller;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.RestResponse;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserResDto;
import com.crypto.base.services.Impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crypto.base.exceptions.BadRequestException;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<RestResponse<SaveUserReq>> createUser(@RequestBody SaveUserReq saveUserReq) {

        if (saveUserReq == null)
            throw new BadRequestException(UserErrorMessage.REQUEST_FAILED);

        userService.saveUser(saveUserReq);

        return new ResponseEntity<>(RestResponse.empty(), HttpStatus.CREATED);
    }
    @PostMapping("/{id}/update")
    public ResponseEntity<RestResponse<SaveUserReq>> updateUser(@PathVariable Long id, @RequestBody SaveUserReq saveUserReq) {

        userService.updateUser(saveUserReq, id);

        return new ResponseEntity<>(RestResponse.empty(), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<RestResponse<List<UserResDto>>> getUser() {
        
        return new ResponseEntity<>(RestResponse.of(userService.getAllUsers()), HttpStatus.OK);

    }
}
