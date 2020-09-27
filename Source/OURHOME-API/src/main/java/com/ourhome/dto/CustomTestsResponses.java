package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="custom_tests_responses")
public class CustomTestsResponses {

	@Id
	@Column(name="custom_test_response_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Users user;
	
	@ManyToOne
	@JoinColumn(name="custom_test_id")
	CustomTests customTest;
	
	@Column(name="answers")
	private String answers;
	
	@Column(name="compatibility")
	private Double compatibility;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;	
	
	public CustomTestsResponses() {}

	/**
	 * @param id
	 * @param user
	 * @param customTest
	 * @param answers
	 * @param compatibility
	 * @param createdAt
	 */
	public CustomTestsResponses(int id, Users user, CustomTests customTest, String answers, Double compatibility,
			Date createdAt) {
		super();
		this.id = id;
		this.user = user;
		this.customTest = customTest;
		this.answers = answers;
		this.compatibility = compatibility;
		this.createdAt = createdAt;
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
	 * @return the user
	 */
	public Users getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Users user) {
		this.user = user;
	}

	/**
	 * @return the custom_test
	 */
	public CustomTests getCustomTest() {
		return customTest;
	}

	/**
	 * @param custom_test the custom_test to set
	 */
	public void setCustomTest(CustomTests custom_test) {
		this.customTest = custom_test;
	}

	/**
	 * @return the answers
	 */
	public String getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(String answers) {
		this.answers = answers;
	}

	/**
	 * @return the compatibility
	 */
	public Double getCompatibility() {
		return compatibility;
	}

	/**
	 * @param compatibility the compatibility to set
	 */
	public void setCompatibility(Double compatibility) {
		this.compatibility = compatibility;
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

	@Override
	public String toString() {
		return "CustomTestsResponses [id=" + id + ", user=" + user + ", custom_test=" + customTest + ", answers="
				+ answers + ", compatibility=" + compatibility + ", createdAt=" + createdAt + "]";
	}
	
}