package com.crypto.base.dto;

import com.crypto.base.entities.enumtype.IsActiveEnum;
import com.crypto.base.entities.enumtype.RoleEnum;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.crypto.base.entities.Portfolio}
 */
@Value
public class PortfolioDtoRes implements Serializable {
    Long id;
    LocalDateTime createDate;
    LocalDateTime updateDate;
    Long createdBy;
    Long updatedBy;
    String name;
    String description;
    Set<TransactionDto1> transactions;
    Set<LikeDto> likes;
    Set<CommentDto> comments;
    UserDto1 user;

    /**
     * DTO for {@link com.crypto.base.entities.Transaction}
     */
    @Value
    public static class TransactionDto1 implements Serializable {
        Long id;
        LocalDateTime createDate;
        LocalDateTime updateDate;
        Long createdBy;
        Long updatedBy;
        IsActiveEnum isActiveEnum;
        Long salePrice;
        Long purchasePrice;
        Long amount;
        Long tokenId;
    }

    /**
     * DTO for {@link com.crypto.base.entities.Like}
     */
    @Value
    public static class LikeDto implements Serializable {
        Long id;
        LocalDateTime createDate;
        LocalDateTime updateDate;
        Long createdBy;
        Long updatedBy;
        int likes;
    }

    /**
     * DTO for {@link com.crypto.base.entities.Comment}
     */
    @Value
    public static class CommentDto implements Serializable {
        Long id;
        LocalDateTime createDate;
        LocalDateTime updateDate;
        Long createdBy;
        Long updatedBy;
        String text;
    }

    /**
     * DTO for {@link com.crypto.base.entities.User}
     */
    @Value
    public static class UserDto1 implements Serializable {
        Long id;
        LocalDateTime createDate;
        LocalDateTime updateDate;
        Long createdBy;
        Long updatedBy;
        RoleEnum roleEnum;
        String name;
        String surName;
        String email;
        String profilePhoto;
        String about;
        String country;
    }
}