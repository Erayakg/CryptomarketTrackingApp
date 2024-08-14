package com.crypto.base.dto;

import com.crypto.base.entities.enumtype.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.crypto.base.entities.User}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SaveUserReq(RoleEnum roleEnum, String name, String surName, String email, String password,
                          String profilePhoto, String about, String country, String username) implements Serializable {
}