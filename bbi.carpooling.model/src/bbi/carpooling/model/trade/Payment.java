package bbi.carpooling.model.trade;

import java.util.Date;

import bbi.carpooling.model.BaseBean;
import bbi.carpooling.model.user.CPUser;

public class Payment extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Date date;
	
	private CPUser user;
	
	private Price price;

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setUser(CPUser user) {
		this.user = user;
	}

	public CPUser getUser() {
		return user;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Price getPrice() {
		return price;
	}

}
