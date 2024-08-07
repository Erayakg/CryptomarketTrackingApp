package com.crypto.base.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.crypto.base.entities.User}
 */
@Value
public class UserResDto implements Serializable {
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
    Set<PortfolioDto> portfolios;
    Set<NotificationDto> notifications;
    String type;

}