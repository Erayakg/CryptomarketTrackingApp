package com.crypto.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link com.crypto.base.entities.Portfolio}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record PortfolioDtoReq(String name, String description) implements Serializable {
}