package com.crypto.base.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TABLE_LIKE")
public class Like extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    private int likes;

    public Like() {
    }

    public Like(Long id, Portfolio portfolio,  int likes) {
        this.id = id;
        this.portfolio = portfolio;
        this.likes = likes;
    }


    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
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
        return likes == like.likes && Objects.equals(id, like.id) && Objects.equals(portfolio, like.portfolio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, portfolio, likes);
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", portfolio=" + portfolio +
                ", likes=" + likes +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
