package bbi.carpooling.model.user;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;

@Entity
public class CPUserInfo extends BaseBean {

	public enum Civility {
		MR, MM, M
	};

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Civility civility;
	private String firstName;
	private String lastName;
	private String eMail;
	private String mobileNumber;
	private Integer yearOfBearth;

	private String photoPath;

	private String adress;
	private String city;
	
	private boolean motorized;

	private CPUser cpUser;

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String geteMail() {
		return eMail;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setYearOfBearth(Integer yearOfBearth) {
		this.yearOfBearth = yearOfBearth;
	}

	public Integer getYearOfBearth() {
		return yearOfBearth;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public Civility getCivility() {
		return civility;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setCpUser(CPUser cpUser) {
		this.cpUser = cpUser;
	}

	@OneToOne
	public CPUser getCpUser() {
		return cpUser;
	}

	public void setMotorized(boolean motorized) {
		this.motorized = motorized;
	}

	public boolean isMotorized() {
		return motorized;
	}

}
