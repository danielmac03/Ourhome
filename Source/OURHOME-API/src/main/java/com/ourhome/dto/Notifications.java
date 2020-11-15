package com.ourhome.dto;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "notifications")
public class Notifications {

    @Id
    @Column(name = "notification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    Users user;

    @Column(name = "content_text")
    private String content_text;


    @Column(name = "content_img")
    private String content_img;


    @Column(name = "content_url")
    private String content_url;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    public Notifications() {}

    public Notifications(int id, Users user, String content_text, String content_img, String content_url, Date createdAt) {
        this.id = id;
        this.user = user;
        this.content_text = content_text;
        this.content_img = content_img;
        this.content_url = content_url;
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

    public String getContent_text() {
        return content_text;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public String getContent_img() {
        return content_img;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
