package com.crypto.base.entities;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Portfolio extends BaseEntity {

    @Column(name = "portfolio_name")
    private String name;

    @Column(name = "description_name")
    private String description;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> transactions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Portfolio() {
    }

    public Portfolio(Long id, String name, String description, Set<Transaction> transactions, Set<Like> likes, Set<Comment> comments, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.transactions = transactions;
        this.likes = likes;
        this.comments = comments;
        this.user = user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id) && Objects.equals(name, portfolio.name) && Objects.equals(description, portfolio.description) && Objects.equals(transactions, portfolio.transactions) && Objects.equals(likes, portfolio.likes) && Objects.equals(comments, portfolio.comments) && Objects.equals(user, portfolio.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, transactions, likes, comments, user);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", transactions=" + transactions +
                ", likes=" + likes +
                ", comments=" + comments +
                ", user=" + user +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
