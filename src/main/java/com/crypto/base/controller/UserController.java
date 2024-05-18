package com.crypto.base.controller;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.RestResponse;
import com.crypto.base.dto.SaveUserReq;
import com.crypto.base.dto.UserDto;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.BadRequestException;
import com.crypto.base.exceptions.NotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping("/createUser")
    public ResponseEntity<RestResponse<SaveUserReq>> createUser(@RequestBody SaveUserReq saveUserReq) {

        if (saveUserReq == null)
            throw new BadRequestException(UserErrorMessage.REQUEST_FAILED);

        return new ResponseEntity<>(RestResponse.empty(), HttpStatus.CREATED);
    }
    @GetMapping("/getUser")
    public ResponseEntity<RestResponse<UserDto>> getUser() {
        throw  new NotfoundException(UserErrorMessage.NOT_FOUND);
    }
}
