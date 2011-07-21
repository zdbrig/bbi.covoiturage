package bbi.carpooling.model.map;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;

@Entity
public class Location extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Place place;
	private String discription;
	private Path path;

	@ManyToOne(optional = false)
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	@OneToOne
	public Path getPath() {
		return path;
	}
}
