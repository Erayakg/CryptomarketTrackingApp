package com.crypto.base.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User{
    @Id
    private Long id;

}
