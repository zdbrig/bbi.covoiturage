package bbi.carpooling.service.impl.dao.map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bbi.carpooling.model.map.WorkArea;
import bbi.carpooling.service.impl.dao.GenericJpaDao;

@Repository("workAreaDao")
public class WorkAreaDao extends GenericJpaDao<WorkArea> {

	public WorkAreaDao() {
		super(WorkArea.class);
	}

}
