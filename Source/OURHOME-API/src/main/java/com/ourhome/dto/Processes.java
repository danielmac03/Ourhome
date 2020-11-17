package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name="processes")
public class Processes {
	
	@Id
	@Column(name="process_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="home_id")
	Homes home;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Users user;

	@Column(name="answers")
	private String answers;

	@Column(name="compatibility")
	private int compatibility;
	
	@Column(name="state")
	private String state;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	public Processes() {}

	public Processes(int id, Homes home, Users user, String answers, int compatibility, String state, Date createdAt, Date updatedAt) {
		this.id = id;
		this.home = home;
		this.user = user;
		this.answers = answers;
		this.compatibility = compatibility;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Homes getHome() {
		return home;
	}

	public void setHome(Homes home) {
		this.home = home;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public int getCompatibility() {
		return compatibility;
	}

	public void setCompatibility(int compatibility) {
		this.compatibility = compatibility;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}