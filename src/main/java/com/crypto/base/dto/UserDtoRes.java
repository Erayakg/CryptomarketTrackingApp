package com.crypto.base.dto;

import com.crypto.base.entities.enumtype.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.crypto.base.entities.User}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDtoRes(Long id, LocalDateTime createDate, LocalDateTime updateDate, Long createdBy, Long updatedBy,
                         RoleEnum roleEnum, String name, String surName, String email, String profilePhoto,
                         String about, String country, Set<PortfolioDto1> portfolios,
                         Set<NotificationDto1> notifications, Set<CommentDto> comments, String username) implements Serializable {
    /**
     * DTO for {@link com.crypto.base.entities.Portfolio}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PortfolioDto1(Long id, LocalDateTime createDate, String name,
                                String description) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.Notification}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record NotificationDto1(Long id, LocalDateTime createDate, String text,
                                   String title) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.Comment}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CommentDto(LocalDateTime createDate, String text) implements Serializable {
    }
}