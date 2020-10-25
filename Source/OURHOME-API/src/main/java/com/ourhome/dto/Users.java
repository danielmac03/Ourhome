package com.ourhome.dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class Users {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surnames")
	private String surnames;

	@Column(name="url_photo")
	private String urlPhoto;

	@Column(name="description")
	private String description;
	
	@Column(name="age")
	private int age;
	
	@Column(name="phone")
	private int phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="default_test_responses")
	private String defaultTestResponses;
	
	@Column(name="show_phone")
	private boolean showPhone;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<Homes> homes;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<Processes> process;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<CustomTests> customTest;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<CustomTestsResponses> customTestsResponses;
	
	public Users() {}
	
	/**
	 * @param id
	 * @param name
	 * @param surnames
	 * @param age
	 * @param phone
	 * @param mail
	 * @param password
	 * @param role
	 * @param defaultTestResponses
	 * @param showPhone
	 * @param createdAt
	 * @param updatedAt
	 * @param homes
	 * @param process
	 * @param customTest
	 * @param customTestsResponses
	 */
	public Users(int id, String name, String surnames, String urlPhoto, String description, int age, int phone, String mail, String password, String role,
			String defaultTestResponses, boolean showPhone, Date createdAt, Date updatedAt, List<Homes> homes,
			List<Processes> process, List<CustomTests> customTest,
			List<CustomTestsResponses> customTestsResponses) {
		super();
		this.id = id;
		this.name = name;
		this.surnames = surnames;
		this.urlPhoto = urlPhoto;
		this.description = description;
		this.age = age;
		this.phone = phone;
		this.email = mail;
		this.password = password;
		this.role = role;
		this.defaultTestResponses = defaultTestResponses;
		this.showPhone = showPhone;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.homes = homes;
		this.process = process;
		this.customTest = customTest;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surnames
	 */
	public String getSurnames() {
		return surnames;
	}

	/**
	 * @param surnames the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * @return the urlPhoto
	 */
	public String getUrlPhoto() {
		return urlPhoto;
	}

	/**
	 * @param urlPhoto the surnames to set
	 */
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the surnames to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the defaultTestResponses
	 */
	public String getDefaultTestResponses() {
		return defaultTestResponses;
	}

	/**
	 * @param defaultTestResponses the defaultTestResponses to set
	 */
	public void setDefaultTestResponses(String defaultTestResponses) {
		this.defaultTestResponses = defaultTestResponses;
	}

	/**
	 * @return the showPhone
	 */
	public boolean isShowPhone() {
		return showPhone;
	}

	/**
	 * @param showPhone the showPhone to set
	 */
	public void setShowPhone(boolean showPhone) {
		this.showPhone = showPhone;
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

	/**
	 * @return the homes
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "homes")
	public List<Homes> getHomes() {
		return homes;
	}

	/**
	 * @param homes the homes to set
	 */
	public void setHomes(List<Homes> homes) {
		this.homes = homes;
	}

	/**
	 * @return the process
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "processes")
	public List<Processes> getProcess() {
		return process;
	}

	/**
	 * @param process the process to set
	 */
	public void setProcess(List<Processes> process) {
		this.process = process;
	}

	/**
	 * @return the customTest
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "custom_test")
	public List<CustomTests> getCustomTest() {
		return customTest;
	}

	/**
	 * @param customTest the customTest to set
	 */
	public void setCustomTest(List<CustomTests> customTest) {
		this.customTest = customTest;
	}

	/**
	 * @return the customTestsResponses
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "custom_tests_responses")
	public List<CustomTestsResponses> getCustomTestsResponses() {
		return customTestsResponses;
	}

	/**
	 * @param customTestsResponses the customTestsResponses to set
	 */
	public void setCustomTestsResponses(List<CustomTestsResponses> customTestsResponses) {
		this.customTestsResponses = customTestsResponses;
	}

}
