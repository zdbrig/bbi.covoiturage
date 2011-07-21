package bbi.carpooling.service.impl.User;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bbi.carpooling.model.user.CPUser;
import bbi.carpooling.model.user.CPUserInfo;
import bbi.carpooling.model.user.CPUserPreferences;
import bbi.carpooling.model.user.Car;
import bbi.carpooling.model.user.Opinion;
import bbi.carpooling.service.api.user.IUserService;
import bbi.carpooling.service.impl.dao.user.CPUserDao;
import bbi.carpooling.service.impl.dao.user.CPUserPathsDao;
import bbi.carpooling.service.impl.dao.user.OpinionDao;

@Service
@Transactional
public class UserServiceImpl implements Serializable, IUserService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource(name="cpUserDao")
	private CPUserDao cpUserDao;
	private CPUserPathsDao cpUserPathsDao;
	private OpinionDao opinionDao;

	@Override
	public CPUser createUser() {
		CPUser cpUser = new CPUser();
		cpUser.setCar(new Car());
		cpUser.setCpUserInfo(new CPUserInfo());
		cpUser.getCpUserInfo().setMotorized(false);
		cpUser.setCpUserPreferences(createCPUserPreferences(cpUser));
		cpUser.getCpUserInfo().setYearOfBearth(1911);
		/*
		 * cpUser.setCpUserPaths(null); cpUser.setGivenOpinion(null);
		 * cpUser.setReceavedOpinion(null);
		 */
		cpUser.setDeleted(false);
		cpUser.setValidated(false);
		cpUser.setValidationCode(generateRandomCode());

		return cpUser;
	}

	private String generateRandomCode() {

		return "rrr";
	}

	@Override
	public CPUser getUser(Long id) {
		return cpUserDao.selectById(id);
	}

	@Override
	public CPUser getUser(String login) {
		CPUser cpUser;
		List<CPUser> l = cpUserDao.select(" login = '" + login+"'");
		if (l.isEmpty())
			cpUser = null;
		else
			return cpUser = l.get(0);
		return cpUser;
	}

	@Override
	public CPUser saveUser(CPUser cpUser) {
		CPUser cpUserret = (CPUser) cpUserDao.save(cpUser);
		boolean userUpdated = false;
		if(cpUserret.getCar().getCpUser()==null){
			cpUserret.getCar().setCpUser(cpUserret);
			userUpdated=true;
			//cpUserret = cpUserDao.save(cpUserret);
		}
		if(cpUserret.getCpUserInfo().getCpUser()==null){
			cpUserret.getCpUserInfo().setCpUser(cpUserret);
			userUpdated=true;
			//cpUserret = cpUserDao.save(cpUserret);
		}
		if (userUpdated)
			cpUserret = cpUserDao.save(cpUserret);
		return cpUserret;
	}

	@Override
	public CPUser validateUser(String login, String validationCode) {
		CPUser cpUser = getUser(login);
		if (validationCode != null
				& validationCode.equals(cpUser.getValidationCode())) {
			cpUser.setValidated(true);
			cpUserDao.save(cpUser);
		}
		return cpUser;
	}

	@Override
	public void deleteUser(CPUser cpUser) {
		cpUserDao.remove(cpUser);

	}

	@Override
	public List<Opinion> getOpinion(CPUser cpUser, OpinionType opinionType) {
		String query = " ";
		if (opinionType.equals(OpinionType.GIVEN))
			query = "fromUser = " + cpUser;
		else
			query = "toUser = " + cpUser;
		List<Opinion> opinions = opinionDao.select(query);
		return opinions;
	}

	@Override
	public Opinion saveOpinion(Opinion givenOpinion) {
		return opinionDao.save(givenOpinion);
	}

	@Override
	public CPUserPreferences createCPUserPreferences(CPUser toUser) {
		CPUserPreferences cpUserPreferences = new CPUserPreferences();
		cpUserPreferences.setAcceptChangeDirection(null);
		cpUserPreferences.setAnimalChoice(null);
		cpUserPreferences.setCpUser(toUser);
		cpUserPreferences.setDeleted(false);
		cpUserPreferences.setDiscussionChoice(null);
		cpUserPreferences.setMusicChoice(null);
		cpUserPreferences.setTabacChoice(null);
		return cpUserPreferences;
	}

	public CPUserDao getCpUserDao() {
		return cpUserDao;
	}

	public void setCpUserDao(CPUserDao cpUserDao) {
		this.cpUserDao = cpUserDao;
	}

	public CPUserPathsDao getCpUserPathsDao() {
		return cpUserPathsDao;
	}

	public void setCpUserPathsDao(CPUserPathsDao cpUserPathsDao) {
		this.cpUserPathsDao = cpUserPathsDao;
	}

	public OpinionDao getOpinionDao() {
		return opinionDao;
	}

	public void setOpinionDao(OpinionDao opinionDao) {
		this.opinionDao = opinionDao;
	}

	@Override
	public Opinion createOpinion(CPUser fromUser, CPUser toUser) {
		Opinion opinion = new Opinion();
		opinion.setDeleted(false);
		opinion.setFromUser(fromUser);
		opinion.setToUser(toUser);
		return opinion;
	}

	@Override
	public String validateUserInfo(CPUser cpUser) {
		String errorMsg ="";
		if (cpUser.getId() == null){
			if(cpUser.getLogin()==null || cpUser.getLogin().length()==0){
				errorMsg = errorMsg+"* Invalid Login!\n";
				}
			else{
				boolean isAvailable = checkLoginAvailibility(cpUser.getLogin());
				if (isAvailable == false){
					System.out.println("not available");
					errorMsg = errorMsg+"* Login already used !\n";
				}
					
					
			}
			if(cpUser.getPassword()==null || cpUser.getPassword().length()==0){
				errorMsg = errorMsg+"* Invalid password!\n";
			}
		}
		
		if(cpUser.getCpUserInfo().getFirstName()==null || cpUser.getCpUserInfo().getFirstName().length()==0){
			errorMsg = errorMsg+"* Please select your Name !\n";
		}
		if(cpUser.getCpUserInfo().getLastName()==null || cpUser.getCpUserInfo().getLastName().length()==0){
			errorMsg = errorMsg+"* Please select your last Name !\n";
		}
		if(cpUser.getCpUserInfo().geteMail()==null || cpUser.getCpUserInfo().geteMail().length()==0){
			errorMsg = errorMsg+"* Please enter your mail adress !\n";
		}
		if(cpUser.getCpUserInfo().getMobileNumber()==null || cpUser.getCpUserInfo().getMobileNumber().length()==0){
			errorMsg = errorMsg+"* Please enter your phone number !\n";
		}
		if(cpUser.getCpUserInfo().getYearOfBearth()==null){
			errorMsg = errorMsg+"* Please select your year of bearth !\n";
		}
		return errorMsg;
	}

	@Override
	public boolean checkLoginAvailibility(String login) {
		CPUser cpUser = getUser(login);
		boolean isAvailabal = true;
		if(cpUser != null)
			isAvailabal = false;
		return isAvailabal;
	}

	@Override
	public CPUser getUser(String login, String pwd) {
		CPUser cpUser;
		
		List<CPUser> l = cpUserDao.select(" login = '" + login+"' and password = '"+pwd+"'");
		if (l.isEmpty())
			cpUser = null;
		else
			return cpUser = l.get(0);
		return cpUser;
	}

}
