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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Portfolio> portfolios = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "TABLE_USER_notifications",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "notifications_id"))
    private Set<Notification> notifications = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FollowingPortfolio> followingPortfolios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new LinkedHashSet<>();

    public User() {
    }

    public User(Long id, RoleEnum roleEnum, String name, String surName, String email, String password, String profilePhoto, String about, String country, Set<Portfolio> portfolios, Set<Notification> notifications, Set<FollowingPortfolio> followingPortfolios, Set<Comment> comments, Set<Like> likes) {
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
        this.followingPortfolios = followingPortfolios;
        this.comments = comments;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<FollowingPortfolio> getFollowingPortfolios() {
        return followingPortfolios;
    }

    public void setFollowingPortfolios(Set<FollowingPortfolio> followingPortfolios) {
        this.followingPortfolios = followingPortfolios;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && roleEnum == user.roleEnum && Objects.equals(name, user.name) && Objects.equals(surName, user.surName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(profilePhoto, user.profilePhoto) && Objects.equals(about, user.about) && Objects.equals(country, user.country) && Objects.equals(portfolios, user.portfolios) && Objects.equals(notifications, user.notifications) && Objects.equals(followingPortfolios, user.followingPortfolios) && Objects.equals(comments, user.comments) && Objects.equals(likes, user.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleEnum, name, surName, email, password, profilePhoto, about, country, portfolios, notifications, followingPortfolios, comments, likes);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roleEnum=" + roleEnum +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", about='" + about + '\'' +
                ", country='" + country + '\'' +
                ", portfolios=" + portfolios +
                ", notifications=" + notifications +
                ", followingPortfolios=" + followingPortfolios +
                ", comments=" + comments +
                ", likes=" + likes +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}