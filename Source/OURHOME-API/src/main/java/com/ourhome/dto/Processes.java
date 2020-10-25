package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
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
	
	@Column(name="state")
	private String state;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	public Processes() {}

	/**
	 * @param id
	 * @param home
	 * @param user
	 * @param state
	 * @param createdAt
	 * @param updatedAt
	 */
	public Processes(int id, Homes home, Users user, String state, Date createdAt, Date updatedAt) {
		this.id = id;
		this.home = home;
		this.user = user;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the home
	 */
	public Homes getHome() {
		return home;
	}

	/**
	 * @param home the user1 to set
	 */
	public void setHome(Homes home) {
		this.home = home;
	}

	/**
	 * @return the user2
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user2 to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}