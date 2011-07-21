package bbi.carpooling.service.impl.dao.user;

import org.springframework.stereotype.Repository;

import bbi.carpooling.model.user.Opinion;
import bbi.carpooling.service.impl.dao.GenericJpaDao;

@Repository("opinionDAO")
public class OpinionDao extends GenericJpaDao<Opinion> {

	public OpinionDao(Class<Opinion> entityBeanType) {
		super(Opinion.class);
	}

}
