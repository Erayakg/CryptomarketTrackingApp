package com.crypto.base.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TABLE_USER")
public class User extends BaseEntity{

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "user_surname")
    private String surName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @Column(name = "user_profile_photo")
    private String profilePhoto;
    @Column(name = "user_about")
    private String about;
    @Column(name = "user_country")
    private String country;

}
