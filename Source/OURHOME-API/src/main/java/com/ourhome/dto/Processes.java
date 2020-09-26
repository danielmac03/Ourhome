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
	@JoinColumn(name="user_id_1")
	Users user1;
	
	@ManyToOne
	@JoinColumn(name="user_id_2")
	Users user2;
	
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
	 * @param user1
	 * @param user2
	 * @param state
	 * @param createdAt
	 * @param updatedAt
	 */
	public Processes(int id, Users user1, Users user2, String state, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
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
	 * @return the user1
	 */
	public Users getUser1() {
		return user1;
	}

	/**
	 * @param user1 the user1 to set
	 */
	public void setUser1(Users user1) {
		this.user1 = user1;
	}

	/**
	 * @return the user2
	 */
	public Users getUser2() {
		return user2;
	}

	/**
	 * @param user2 the user2 to set
	 */
	public void setUser2(Users user2) {
		this.user2 = user2;
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

	@Override
	public String toString() {
		return "Procesos [id=" + id + ", user1=" + user1 + ", user2=" + user2 + ", state=" + state + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}