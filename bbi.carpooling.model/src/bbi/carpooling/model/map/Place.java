package bbi.carpooling.model.map;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import bbi.carpooling.model.BaseBean;

@Entity
public class Place extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String placeName;
	private Double xPosition;
	private Double yPosition;
	
	private transient Set<WorkArea> workArea;
	
	private Set<Path> path;
	
	private Set<Location> location;



	
	public Double getxPosition() {
		return xPosition;
	}
	public void setxPosition(Double xPosition) {
		this.xPosition = xPosition;
	}
	public Double getyPosition() {
		return yPosition;
	}
	public void setyPosition(Double yPosition) {
		this.yPosition = yPosition;
	}
	public void setLocation(Set<Location> location) {
		this.location = location;
	}
	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Location> getLocation() {
		return location;
	}

	public void setPath(Set<Path> path) {
		this.path = path;
	}
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<Path> getPath() {
		return path;
	}
	public void setWorkArea(Set<WorkArea> workArea) {
		this.workArea = workArea;
	}

	@Transient
	public Set<WorkArea> getWorkArea() {
		return workArea;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getPlaceName() {
		return placeName;
	}

}
