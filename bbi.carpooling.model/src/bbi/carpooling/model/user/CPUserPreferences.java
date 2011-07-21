package bbi.carpooling.model.user;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;

@Entity
public class CPUserPreferences extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean musicChoice;
	private Boolean tabacChoice;
	private Boolean animalChoice;
	private Boolean discussionChoice;
	private Boolean acceptChangeDirection;

	private CPUser cpUser;

	public Boolean getMusicChoice() {
		return musicChoice;
	}

	public void setMusicChoice(Boolean musicChoice) {
		this.musicChoice = musicChoice;
	}

	public Boolean getTabacChoice() {
		return tabacChoice;
	}

	public void setTabacChoice(Boolean tabacChoice) {
		this.tabacChoice = tabacChoice;
	}

	public Boolean getAnimalChoice() {
		return animalChoice;
	}

	public void setAnimalChoice(Boolean animalChoice) {
		this.animalChoice = animalChoice;
	}

	public Boolean getDiscussionChoice() {
		return discussionChoice;
	}

	public void setDiscussionChoice(Boolean discussionChoice) {
		this.discussionChoice = discussionChoice;
	}

	public Boolean getAcceptChangeDirection() {
		return acceptChangeDirection;
	}

	public void setAcceptChangeDirection(Boolean acceptChangeDirection) {
		this.acceptChangeDirection = acceptChangeDirection;
	}

	public void setCpUser(CPUser cpUser) {
		this.cpUser = cpUser;
	}

	@OneToOne
	public CPUser getCpUser() {
		return cpUser;
	}

}
