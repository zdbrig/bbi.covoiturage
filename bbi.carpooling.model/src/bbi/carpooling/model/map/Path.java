package bbi.carpooling.model.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;
import bbi.carpooling.model.trade.Price;
import bbi.carpooling.model.user.CPUserPaths;

@Entity
public class Path extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Location start;
	private Location end;
	private List<Place> interPlaces;

	private Integer nbPlaces;

	private Price placePrice;
	
	private boolean isCanceled;
	
	private long color;

	private CPUserPaths cpUserPaths;

	@OneToOne
	public Location getStart() {
		return start;
	}

	public void setStart(Location start) {
		this.start = start;
	}

	@OneToOne
	public Location getEnd() {
		return end;
	}

	public void setEnd(Location end) {
		this.end = end;
	}

	public void setInterPlaces(List<Place> interPlaces) {
		this.interPlaces = interPlaces;
	}

	@ManyToMany(mappedBy = "path", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Place> getInterPlaces() {
		return interPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setPlacePrice(Price placePrice) {
		this.placePrice = placePrice;
	}

	
	public Price getPlacePrice() {
		return placePrice;
	}

	public void setCpUserPaths(CPUserPaths cpUserPaths) {
		this.cpUserPaths = cpUserPaths;
	}

	@ManyToOne(optional = false)
	public CPUserPaths getCpUserPaths() {
		return cpUserPaths;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public void setColor(long color) {
		this.color = color;
	}

	public long getColor() {
		return color;
	}

}
