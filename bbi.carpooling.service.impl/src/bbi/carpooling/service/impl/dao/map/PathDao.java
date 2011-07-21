package bbi.carpooling.service.impl.dao.map;

import bbi.carpooling.model.map.Path;
import bbi.carpooling.service.impl.dao.GenericJpaDao;

public class PathDao extends GenericJpaDao<Path>{

	public PathDao(Class<Path> entityBeanType) {
		super(Path.class);
	}

}
