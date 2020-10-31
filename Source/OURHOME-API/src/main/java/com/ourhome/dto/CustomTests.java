package com.ourhome.dto;

import java.util.List;
import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@OneToMany
	@JoinColumn(name="custom_test_id")
	private List<CustomTestsResponses> customTestsResponses;
	
	public CustomTests() {}

	/**
	 * @param id
	 * @param user
	 * @param questions
	 * @param answers
	 * @param createdAt
	 * @param customTestsResponses
	 */
	public CustomTests(int id, Users user, String questions, String answers, Date createdAt,
					   List<CustomTestsResponses> customTestsResponses) {
		super();
		this.id = id;
		this.user = user;
		this.questions = questions;
		this.answers = answers;
		this.createdAt = createdAt;
		this.customTestsResponses = customTestsResponses;
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
	 * @return the correctAnswers
	 */
	public String getQuestions() {
		return questions;
	}

	/**
	 * @param correctAnswers the correctAnswers to set
	 */
	public void setQuestions(String correctAnswers) {
		this.questions = correctAnswers;
	}

	/**
	 * @return the minimumCorrectResponses
	 */
	public String getAnswers() {
		return answers;
	}

	/**
	 * @param minimumCorrectResponses the minimumCorrectResponses to set
	 */
	public void setAnswers(String minimumCorrectResponses) {
		this.answers = minimumCorrectResponses;
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
	 * @return the respuestasTestsPersonalizados
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "custom_tests_responses")
	public List<CustomTestsResponses> getRespuestasTestsPersonalizados() {
		return customTestsResponses;
	}

	/**
	 * @param customTestsResponses the respuestasTestsPersonalizados to set
	 */
	public void setRespuestasTestsPersonalizados(List<CustomTestsResponses> customTestsResponses) {
		this.customTestsResponses = customTestsResponses;
	}
	
}