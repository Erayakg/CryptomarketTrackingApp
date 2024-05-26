package com.crypto.base.dto.request;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.crypto.base.entities.Portfolio}
 */
@Value
public class CreatePortfolioDto implements Serializable {
    String name;
    String description;
}