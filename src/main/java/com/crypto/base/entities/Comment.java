package com.crypto.base.entities;

import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private String text;

    public Comment() {
    }

    public Comment(Long id, Portfolio portfolio, User user, String text) {
        this.id = id;
        this.portfolio = portfolio;
        this.user = user;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(portfolio, comment.portfolio) && Objects.equals(user, comment.user) && Objects.equals(text, comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, portfolio, user, text);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", portfolio=" + portfolio +
                ", user=" + user +
                ", text='" + text + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}