package com.crypto.base.dto;

import com.crypto.base.entities.enumtype.IsActiveEnum;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.crypto.base.entities.Transaction}
 */
@Value
public class TransactionDto implements Serializable {
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