package com.crypto.base.entities;

import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
public class Like extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int likes;

    public Like() {
    }

    public Like(Long id, Portfolio portfolio, User user, int likes) {
        this.id = id;
        this.portfolio = portfolio;
        this.user = user;
        this.likes = likes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return likes == like.likes && Objects.equals(id, like.id) && Objects.equals(portfolio, like.portfolio) && Objects.equals(user, like.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, portfolio, user, likes);
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", portfolio=" + portfolio +
                ", user=" + user +
                ", likes=" + likes +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
