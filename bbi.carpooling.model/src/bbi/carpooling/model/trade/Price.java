package bbi.carpooling.model.trade;

import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;
import bbi.carpooling.model.map.Path;

@Entity
public class Price extends BaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private float value;
	private Currency currency;

	private Path path;

	public void setValue(float value) {
		this.value = value;

	}

	public float getValue() {
		return value;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	@OneToOne
	public Path getPath() {
		return path;
	}

}
