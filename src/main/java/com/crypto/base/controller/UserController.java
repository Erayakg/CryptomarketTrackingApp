package com.crypto.base.controller;

import com.crypto.base.constant.UserErrorMessage;
import com.crypto.base.dto.RestResponse;
import com.crypto.base.dto.UserDto;
import com.crypto.base.entities.User;
import com.crypto.base.exceptions.NotfoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @GetMapping("/getUser")
    public ResponseEntity<RestResponse<UserDto>> getUser() {
        throw  new NotfoundException(UserErrorMessage.NOT_FOUND);
    }
}
