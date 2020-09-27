package com.ourhome.dto;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="homes")
public class Homes {

	@Id
	@Column(name="home_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	Users user;
	
	@Column(name="url_photos")
	private String urlPhotos;

	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private double price;
		
	@Column(name="num_bedrooms")
	private int numBedrooms;
	
	@Column(name="num_bathroom")
	private int numBathroom;
	
	@Column(name="city")
	private String city;
	
	@Column(name="direction")
	private String direction;
	
	@Column(name="meters")
	private double meters;
	
	@Column(name="floors")
	private int floors;
	
	@Column(name="additional")
	private String additional;
	
	@CreationTimestamp
	@Column(name="created_at")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updatedAt;
	
	public Homes() {}

	/**
	 * @param id
	 * @param user
	 * @param urlPhotos
	 * @param description
	 * @param price
	 * @param numBedrooms
	 * @param numBathroom
	 * @param city
	 * @param direction
	 * @param meters
	 * @param floors
	 * @param additional
	 * @param createdAt
	 * @param updatedAt
	 */
	public Homes(int id, Users user, String urlPhotos, String description, double price, int numBedrooms,
			int numBathroom, String city, String direction, double meters, int floors, String additional, Date createdAt,
			Date updatedAt) {
		super();
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
	 * @return the urlPhotos
	 */
	public String getUrlPhotos() {
		return urlPhotos;
	}

	/**
	 * @param urlPhotos the urlPhotos to set
	 */
	public void setUrlPhotos(String urlPhotos) {
		this.urlPhotos = urlPhotos;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the numBedrooms
	 */
	public int getNumBedrooms() {
		return numBedrooms;
	}

	/**
	 * @param numBedrooms the numBedrooms to set
	 */
	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	/**
	 * @return the numBathroom
	 */
	public int getNumBathroom() {
		return numBathroom;
	}

	/**
	 * @param numBathroom the numBathroom to set
	 */
	public void setNumBathroom(int numBathroom) {
		this.numBathroom = numBathroom;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the meters
	 */
	public double getMeters() {
		return meters;
	}

	/**
	 * @param meters the meters to set
	 */
	public void setMeters(double meters) {
		this.meters = meters;
	}

	/**
	 * @return the floors
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * @param floors the floors to set
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}

	/**
	 * @return the additional
	 */
	public String getAdditional() {
		return additional;
	}

	/**
	 * @param additional the additional to set
	 */
	public void setAdditional(String additional) {
		this.additional = additional;
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
		return "Homes [id=" + id + ", user=" + user + ", urlPhotos=" + urlPhotos + ", description=" + description
				+ ", price=" + price + ", numBedrooms=" + numBedrooms + ", numBathroom=" + numBathroom + ", city=" 
				+ city + ", direction="	+ direction + ", meters=" + meters + ", floors=" + floors + ", additional=" 
				+ additional + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
