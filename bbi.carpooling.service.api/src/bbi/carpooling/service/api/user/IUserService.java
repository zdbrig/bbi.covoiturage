package bbi.carpooling.service.api.user;

import java.util.List;

import bbi.carpooling.model.user.CPUser;
import bbi.carpooling.model.user.CPUserPreferences;
import bbi.carpooling.model.user.Opinion;

public interface IUserService {

	public enum OpinionType {
		GIVEN, RECEIVED
	};

	// User Functions
	CPUser createUser();

	CPUser getUser(Long id);

	CPUser getUser(String login);
	CPUser getUser(String login, String pwd);

	CPUser saveUser(CPUser cpUser);

	CPUser validateUser(String login, String validationCode);

	void deleteUser(CPUser cpUser);
	
	String validateUserInfo(CPUser cpUser);
	
	boolean checkLoginAvailibility(String login);

	// Opinion Functions
	Opinion createOpinion(CPUser fromUser, CPUser toUser);

	List<Opinion> getOpinion(CPUser cpUser, OpinionType opinionType);

	Opinion saveOpinion(Opinion givenOpinion);

	// Preferences Functions
	CPUserPreferences createCPUserPreferences(CPUser toUser);

}
