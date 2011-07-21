package bbi.carpooling.service.impl.dao.user;

import org.springframework.stereotype.Repository;

import bbi.carpooling.model.user.CPUserPaths;
import bbi.carpooling.service.impl.dao.GenericJpaDao;

@Repository("cpUserPathsDAO")
public class CPUserPathsDao extends GenericJpaDao<CPUserPaths> {

	public CPUserPathsDao(Class<CPUserPaths> entityBeanType) {
		super(CPUserPaths.class);
	}

}
