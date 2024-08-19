package com.crypto.base.entities;

import com.crypto.base.entities.enumtype.RoleEnum;
import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.HashSet;
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

    @ManyToMany( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name =  "TABLE_Portfolio_User",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PORTFOLIO_ID"))
    private Set<Portfolio> portfolios = new HashSet<>();

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

    public void addPortfolio(Portfolio portfolio) {
        this.portfolios.add(portfolio);
        portfolio.getUser().add(this);
    }
    public void removePortfolio(Portfolio portfolio) {
        this.portfolios.remove(portfolio);
        portfolio.getUser().remove(this);
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}