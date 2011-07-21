package bbi.carpooling.model.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;

@Entity
public class Car extends BaseBean {

	public enum Comfort {
		BASIC, NORMAL, COMFORTABLE, LUXURY
	};

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String brand;
	private String model;
	private Comfort comfort;
	private Integer numberOfPlaces;
	private String color;
	private String photoPath;

	private CPUser cpUser;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Comfort getComfort() {
		return comfort;
	}

	public void setComfort(Comfort comfort) {
		this.comfort = comfort;
	}

	public Integer getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(Integer numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public void setCpUser(CPUser cpUser) {
		this.cpUser = cpUser;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public CPUser getCpUser() {
		return cpUser;
	}

}
