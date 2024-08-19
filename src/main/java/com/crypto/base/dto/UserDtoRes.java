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
                         RoleEnum roleEnum, String name, String username, String surName, String email,
                         String profilePhoto, String about, String country, Set<PortfolioDto> portfolios,
                         Set<NotificationDto> notifications, Set<CommentDto> comments) implements Serializable {
    /**
     * DTO for {@link com.crypto.base.entities.Portfolio}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PortfolioDto(Long id, LocalDateTime createDate, LocalDateTime updateDate, Long createdBy,
                               Long updatedBy, String name, String description) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.Notification}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record NotificationDto(Long id, LocalDateTime createDate, LocalDateTime updateDate, Long createdBy,
                                  Long updatedBy, String text, String title) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.Comment}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CommentDto(Long id, LocalDateTime createDate, LocalDateTime updateDate, Long createdBy,
                             Long updatedBy, String text) implements Serializable {
    }
}