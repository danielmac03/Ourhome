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
	
	@Column(name="correct_answers")
	private String correctAnswers;
	
	@Column(name="minimum_correct_responses")
	private int minimumCorrectResponses;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@OneToMany
	@JoinColumn(name="custom_test_id")
	private List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados;
	
	public CustomTests() {}

	/**
	 * @param id
	 * @param user
	 * @param correctAnswers
	 * @param minimumCorrectResponses
	 * @param createdAt
	 * @param respuestasTestsPersonalizados
	 */
	public CustomTests(int id, Users user, String correctAnswers, int minimumCorrectResponses, Date createdAt,
			List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados) {
		super();
		this.id = id;
		this.user = user;
		this.correctAnswers = correctAnswers;
		this.minimumCorrectResponses = minimumCorrectResponses;
		this.createdAt = createdAt;
		this.respuestasTestsPersonalizados = respuestasTestsPersonalizados;
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
	public String getCorrectAnswers() {
		return correctAnswers;
	}

	/**
	 * @param correctAnswers the correctAnswers to set
	 */
	public void setCorrectAnswers(String correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	/**
	 * @return the minimumCorrectResponses
	 */
	public int getMinimumCorrectResponses() {
		return minimumCorrectResponses;
	}

	/**
	 * @param minimumCorrectResponses the minimumCorrectResponses to set
	 */
	public void setMinimumCorrectResponses(int minimumCorrectResponses) {
		this.minimumCorrectResponses = minimumCorrectResponses;
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
	public List<RespuestasTestsPersonalizados> getRespuestasTestsPersonalizados() {
		return respuestasTestsPersonalizados;
	}

	/**
	 * @param respuestasTestsPersonalizados the respuestasTestsPersonalizados to set
	 */
	public void setRespuestasTestsPersonalizados(List<RespuestasTestsPersonalizados> respuestasTestsPersonalizados) {
		this.respuestasTestsPersonalizados = respuestasTestsPersonalizados;
	}

	@Override
	public String toString() {
		return "CustomTests [id=" + id + ", user=" + user + ", correctAnswers=" + correctAnswers
				+ ", minimumCorrectResponses=" + minimumCorrectResponses + ", createdAt=" + createdAt
				+ ", respuestasTestsPersonalizados=" + respuestasTestsPersonalizados + "]";
	}
	
}