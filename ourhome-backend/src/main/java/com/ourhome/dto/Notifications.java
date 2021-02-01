package com.ourhome.dto;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Audited
@Table(name = "notifications")
public class Notifications {

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    @Column(name = "text")
    private String text;

    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "url")
    private String url;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    public Notifications() {
    }

    public Notifications(int id, Users user, String text, byte[] photo, String url, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.text = text;
        this.photo = photo;
        this.url = url;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
