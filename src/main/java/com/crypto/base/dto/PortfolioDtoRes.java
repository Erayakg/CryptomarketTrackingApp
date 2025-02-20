package com.crypto.base.dto;

import com.crypto.base.entities.enumtype.IsActiveEnum;
import com.crypto.base.entities.enumtype.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.crypto.base.entities.Portfolio}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PortfolioDtoRes(Long id, LocalDateTime createDate, LocalDateTime updateDate, String name,
                              String description, Set<TransactionDto1> transactions, Set<LikeDto> likes,
                              Set<CommentDto> comments, Set<UserDto1> user) implements Serializable {
    /**
     * DTO for {@link com.crypto.base.entities.Transaction}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TransactionDto1(Long id, LocalDateTime createDate, LocalDateTime updateDate,
                                  IsActiveEnum isActiveEnum, Long salePrice, Long purchasePrice, Long amount,
                                  Long tokenId) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.Like}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record LikeDto(Long id, LocalDateTime createDate, int likes) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.Comment}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CommentDto(Long id, LocalDateTime createDate, LocalDateTime updateDate,
                             String text) implements Serializable {
    }

    /**
     * DTO for {@link com.crypto.base.entities.User}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record UserDto1(LocalDateTime createDate, RoleEnum roleEnum, String username) implements Serializable {
    }
}