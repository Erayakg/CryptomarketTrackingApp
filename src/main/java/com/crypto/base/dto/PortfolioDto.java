package com.crypto.base.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link com.crypto.base.entities.Portfolio}
 */
@Value
public class PortfolioDto implements Serializable {
    LocalDateTime createDate;
    LocalDateTime updateDate;
    Long createdBy;
    Long updatedBy;
    Long id;
    String name;
    String description;
    Set<TransactionDto> transactions;
}