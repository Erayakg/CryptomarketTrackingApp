package com.crypto.base.entities;

import jakarta.persistence.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Notification extends BaseEntity {

    private String text;
    private String title;

    @ManyToMany(mappedBy = "notifications")
    private Set<User> users = new LinkedHashSet<>();

    public Notification() {
    }

    public Notification(Long id, String text, String title, Set<User> users) {
        this.id = id;
        this.text = text;
        this.title = title;
        this.users = users;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) && Objects.equals(text, that.text) && Objects.equals(title, that.title) && Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, title, users);
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", users=" + users +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", createdBy=" + createdBy +
                ", updatedBy=" + updatedBy +
                '}';
    }
}
