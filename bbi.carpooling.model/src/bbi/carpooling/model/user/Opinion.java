package bbi.carpooling.model.user;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import bbi.carpooling.model.BaseBean;

@Entity
public class Opinion extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private CPUser fromUser;
	@ManyToOne
	private CPUser toUser;

	public CPUser getFromUser() {
		return fromUser;
	}

	public void setFromUser(CPUser fromUser) {
		this.fromUser = fromUser;
	}

	public CPUser getToUser() {
		return toUser;
	}

	public void setToUser(CPUser toUser) {
		this.toUser = toUser;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	private String opinion;

}
