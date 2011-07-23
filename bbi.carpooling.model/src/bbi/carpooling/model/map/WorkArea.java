package bbi.carpooling.model.map;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Transient;

import bbi.carpooling.model.BaseBean;

@Entity
public class WorkArea extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String areaName;
	private String continent;
	private String country;
	private String state;
	private Integer affinityLevel = 1;
	private Integer nbrFixLevels = 1;
	
	
	private double xPosition;
	private double yPosition;
	private Integer zoomLevel = 0;



	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getAffinityLevel() {
		return affinityLevel;
	}

	public void setAffinityLevel(Integer affinityLevel) {
		this.affinityLevel = affinityLevel;
	}

	public Integer getNbrFixLevels() {
		return nbrFixLevels;
	}

	public void setNbrFixLevels(Integer nbrFixLevels) {
		this.nbrFixLevels = nbrFixLevels;
	}

	

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaName() {
		return areaName;
	}

	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public Integer getZoomLevel() {
		return zoomLevel;
	}

	public void setZoomLevel(Integer zoomLevel) {
		this.zoomLevel = zoomLevel;
	}

}
