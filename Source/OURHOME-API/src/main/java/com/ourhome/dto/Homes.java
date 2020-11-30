package com.ourhome.dto;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "homes")
public class Homes {

	@Id
	@Column(name = "home_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	Users user;
	
	@Column(name = "url_photos")
	private String urlPhotos;

	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
		
	@Column(name = "num_bedrooms")
	private int numBedrooms;
	
	@Column(name = "num_bathroom")
	private int numBathroom;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "meters")
	private double meters;
	
	@Column(name = "floors")
	private int floors;
	
	@Column(name = "additional")
	private String additional;

	@Column(name = "active")
	private boolean active;
	
	@CreationTimestamp
	@Column(name = "created_at")
	private Timestamp createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@OneToMany
	@JoinColumn(name = "home_id")
	private List<Processes> process;
	
	public Homes() {}

	public Homes(int id, Users user, String urlPhotos, String description, double price, int numBedrooms, int numBathroom, String city, String direction, double meters, int floors, String additional, boolean active, Timestamp createdAt, Timestamp updatedAt, List<Processes> process) {
		this.id = id;
		this.user = user;
		this.urlPhotos = urlPhotos;
		this.description = description;
		this.price = price;
		this.numBedrooms = numBedrooms;
		this.numBathroom = numBathroom;
		this.city = city;
		this.direction = direction;
		this.meters = meters;
		this.floors = floors;
		this.additional = additional;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.process = process;
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

	public String getUrlPhotos() {
		return urlPhotos;
	}

	public void setUrlPhotos(String urlPhotos) {
		this.urlPhotos = urlPhotos;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumBedrooms() {
		return numBedrooms;
	}

	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	public int getNumBathroom() {
		return numBathroom;
	}

	public void setNumBathroom(int numBathroom) {
		this.numBathroom = numBathroom;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public double getMeters() {
		return meters;
	}

	public void setMeters(double meters) {
		this.meters = meters;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "processes")
	public List<Processes> getProcess() {
		return process;
	}

	public void setProcess(List<Processes> process) {
		this.process = process;
	}

}
