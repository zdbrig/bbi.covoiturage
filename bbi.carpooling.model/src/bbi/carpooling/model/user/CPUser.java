package bbi.carpooling.model.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;

@Entity
public class CPUser extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	private boolean validated;
	private String validationCode;

	private String ipAdress;

	private CPUserInfo cpUserInfo;
	private CPUserPreferences cpUserPreferences;
	private Car car;

	private CPUserPaths cpUserPaths;

	private Set<Opinion> givenOpinion;
	private Set<Opinion> receavedOpinion;

	@OneToMany(mappedBy = "fromUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Opinion> getGivenOpinion() {
		return givenOpinion;
	}

	public void setGivenOpinion(Set<Opinion> givenOpinion) {
		this.givenOpinion = givenOpinion;
	}

	@OneToMany(mappedBy = "toUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Opinion> getReceavedOpinion() {
		return receavedOpinion;
	}

	public void setReceavedOpinion(Set<Opinion> receavedOpinion) {
		this.receavedOpinion = receavedOpinion;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public CPUserPreferences getCpUserPreferences() {
		return cpUserPreferences;
	}

	public void setCpUserPreferences(CPUserPreferences cpUserPreferences) {
		this.cpUserPreferences = cpUserPreferences;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setCpUserInfo(CPUserInfo cpUserInfo) {
		this.cpUserInfo = cpUserInfo;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public CPUserInfo getCpUserInfo() {
		return cpUserInfo;
	}

	public void setCpUserPaths(CPUserPaths cpUserPaths) {
		this.cpUserPaths = cpUserPaths;
	}

	@OneToOne(cascade=CascadeType.ALL)
	public CPUserPaths getCpUserPaths() {
		return cpUserPaths;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public String getValidationCode() {
		return validationCode;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

}
