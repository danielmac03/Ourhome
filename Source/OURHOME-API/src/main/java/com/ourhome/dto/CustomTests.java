package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="custom_tests")
public class CustomTests {
	
	@Id
	@Column(name="custom_test_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Users user;
	
	@Column(name="questions")
	private String questions;
	
	@Column(name="answers")
	private String answers;

	@Column(name="options1")
	private String options1;

	@Column(name="options2")
	private String options2;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;

	public CustomTests() {}

	public CustomTests(int id, Users user, String questions, String answers, String options1, String options2, Date createdAt) {
		this.id = id;
		this.user = user;
		this.questions = questions;
		this.answers = answers;
		this.options1 = options1;
		this.options2 = options2;
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

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public String getOptions1() {
		return options1;
	}

	public void setOptions1(String options1) {
		this.options1 = options1;
	}

	public String getOptions2() {
		return options2;
	}

	public void setOptions2(String options2) {
		this.options2 = options2;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}