package com.crypto.base.entities;

import com.crypto.base.entities.enumtype.RoleEnum;
import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TABLE_USER")
public class User extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum roleEnum;

    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    private String surName;

    private String email;

    private String password;

    private String profilePhoto;

    @Column(length = 1000)
    private String about;

    private String country;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Portfolio> portfolios = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "TABLE_USER_notifications",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "notifications_id"))
    private Set<Notification> notifications = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    public User(Long id, RoleEnum roleEnum, String name, String username, String surName, String email, String password, String profilePhoto, String about, String country, Set<Portfolio> portfolios, Set<Notification> notifications, Set<Comment> comments) {
        this.username = username;
        this.id = id;
        this.roleEnum = roleEnum;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.profilePhoto = profilePhoto;
        this.about = about;
        this.country = country;
        this.portfolios = portfolios;
        this.notifications = notifications;
        this.comments = comments;
    }

    public User() {
    }

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Set<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return roleEnum == user.roleEnum && Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(surName, user.surName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(profilePhoto, user.profilePhoto) && Objects.equals(about, user.about) && Objects.equals(country, user.country) && Objects.equals(portfolios, user.portfolios) && Objects.equals(notifications, user.notifications) && Objects.equals(comments, user.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleEnum, name, username, surName, email, password, profilePhoto, about, country, portfolios, notifications, comments);
    }

    @Override
    public String toString() {
        return "User{" +
                "comments=" + comments +
                ", roleEnum=" + roleEnum +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", about='" + about + '\'' +
                ", country='" + country + '\'' +
                ", portfolios=" + portfolios +
                ", notifications=" + notifications +
                ", id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}