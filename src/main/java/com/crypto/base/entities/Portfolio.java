package com.crypto.base.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Portfolio {
    @Id
    private Long id;

}
