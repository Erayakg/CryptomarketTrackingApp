package com.crypto.base.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.crypto.base.entities.User}
 */
@Value
public class UserDto implements Serializable {
    LocalDateTime createDate;
    LocalDateTime updateDate;
    Long createdBy;
    Long updatedBy;
    String name;
    String surName;
    String email;
    String profilePhoto;
    String about;
    String country;
    String username;
}