package com.ourhome.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Audited
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surnames")
    private String surnames;

    @Column(name = "company")
    private String company;

    @Column(name = "direction")
    private String direction;

    @Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Column(name = "description")
    private String description;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "default_test_responses")
    private String defaultTestResponses;

    @Column(name = "show_phone")
    private boolean showPhone;

    @Column(name = "remaining_publications")
    private int remainingPublications;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Homes> homes;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Processes> process;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<CustomTests> customTest;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Notifications> notifications;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Tokens> tokens;

    public Users() {
    }

    public Users(int id, String name, String surnames, String company, String direction, byte[] profilePicture, String description, Date birthdate, Integer phone, String email, String password, String role, String defaultTestResponses, boolean showPhone, int remainingPublications, Timestamp createdAt, Timestamp updatedAt, List<Homes> homes, List<Processes> process, List<CustomTests> customTest, List<Notifications> notifications, List<Tokens> tokens) {
        this.id = id;
        this.name = name;
        this.surnames = surnames;
        this.company = company;
        this.direction = direction;
        this.profilePicture = profilePicture;
        this.description = description;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.defaultTestResponses = defaultTestResponses;
        this.showPhone = showPhone;
        this.remainingPublications = remainingPublications;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.homes = homes;
        this.process = process;
        this.customTest = customTest;
        this.notifications = notifications;
        this.tokens = tokens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDefaultTestResponses() {
        return defaultTestResponses;
    }

    public void setDefaultTestResponses(String defaultTestResponses) {
        this.defaultTestResponses = defaultTestResponses;
    }

    public boolean isShowPhone() {
        return showPhone;
    }

    public void setShowPhone(boolean showPhone) {
        this.showPhone = showPhone;
    }

    public int getRemainingPublications() {
        return remainingPublications;
    }

    public void setRemainingPublications(int remainingPublications) {
        this.remainingPublications = remainingPublications;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "homes")
    public List<Homes> getHomes() {
        return homes;
    }

    public void setHomes(List<Homes> homes) {
        this.homes = homes;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "processes")
    public List<Processes> getProcess() {
        return process;
    }

    public void setProcess(List<Processes> process) {
        this.process = process;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "custom_test")
    public List<CustomTests> getCustomTest() {
        return customTest;
    }

    public void setCustomTest(List<CustomTests> customTest) {
        this.customTest = customTest;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notifications")
    public List<Notifications> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notifications> notifications) {
        this.notifications = notifications;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tokens")
    public List<Tokens> getTokens() {
        return tokens;
    }

    public void setTokens(List<Tokens> tokens) {
        this.tokens = tokens;
    }
}
