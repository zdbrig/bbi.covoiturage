package bbi.carpooling.service.impl.dao.user;

import org.springframework.stereotype.Repository;

import bbi.carpooling.service.impl.dao.GenericJpaDao;
import bbi.carpooling.model.user.CPUser;

@Repository("cpUserDAO")
public class CPUserDao extends GenericJpaDao<CPUser> {

	public CPUserDao() {
		super(CPUser.class);
	}

}
