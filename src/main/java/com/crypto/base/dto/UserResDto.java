package com.crypto.base.dto;

import com.crypto.base.entities.enumtype.IsActiveEnum;
import com.crypto.base.entities.enumtype.RoleEnum;
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
    Long id;
    RoleEnum roleEnum;
    String name;
    String surName;
    String email;
    String profilePhoto;
    String about;
    String country;
    Set<PortfolioDto> portfolios;
    Set<NotificationDto> notifications;

    /**
     * DTO for {@link com.crypto.base.entities.Portfolio}
     */
    @Value
    public static class PortfolioDto implements Serializable {
        LocalDateTime createDate;
        LocalDateTime updateDate;
        Long createdBy;
        Long updatedBy;
        Long id;
        String name;
        String description;
        Set<TransactionDto> transactions;

        /**
         * DTO for {@link com.crypto.base.entities.Transaction}
         */
        @Value
        public static class TransactionDto implements Serializable {
            LocalDateTime createDate;
            LocalDateTime updateDate;
            Long createdBy;
            Long updatedBy;
            Long id;
            IsActiveEnum isActiveEnum;
            Long salePrice;
            Long purchasePrice;
            Long amount;
            Long tokenId;
        }
    }

    /**
     * DTO for {@link com.crypto.base.entities.Notification}
     */
    @Value
    public static class NotificationDto implements Serializable {
        LocalDateTime createDate;
        LocalDateTime updateDate;
        Long createdBy;
        Long updatedBy;
        Long id;
        String text;
        String title;
    }
}