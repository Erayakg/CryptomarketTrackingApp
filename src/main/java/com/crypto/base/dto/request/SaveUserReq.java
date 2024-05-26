package com.crypto.base.dto.request;

import com.crypto.base.entities.User;
import com.crypto.base.entities.enumtype.RoleEnum;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value
public class SaveUserReq implements Serializable {
    RoleEnum roleEnum;
    String name;
    String surName;
    String email;
    String password;
    String profilePhoto;
    String about;
    String country;
}