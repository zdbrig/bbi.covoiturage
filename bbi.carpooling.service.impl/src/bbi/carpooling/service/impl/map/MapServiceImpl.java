package bbi.carpooling.service.impl.map;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import bbi.carpooling.model.map.WorkArea;
import bbi.carpooling.service.api.map.IMapService;
import bbi.carpooling.service.impl.dao.map.WorkAreaDao;

public class MapServiceImpl implements IMapService {

	@Resource(name = "workAreaDao")
	private WorkAreaDao workAreaDao;
	private List<WorkArea> workAreas = new ArrayList<WorkArea>();

	
	 @Transactional
	public void init() {
		
//		getWorkAreaDao().executeQuery(query)
		workAreas = workAreaDao.select();

		
		
		if (workAreas.isEmpty()) {
			System.out.println("MapServiceImpl.init()" + " EMPTY");
			WorkArea area1 = new WorkArea();
			area1.setAreaName("Tunisia");
			area1.setCountry("Tunisia");
			area1.setxPosition(31.6);
			area1.setyPosition(31.6);
			area1.setZoomLevel(10);
			
			WorkArea workArea = workAreaDao.save(area1);
			System.out.println("MapServiceImpl.init() id  = " + workArea.getId() );
			
			workAreas.add(workArea);
		}

		workAreas = workAreaDao.select();
		System.out.println("MapServiceImpl.init()" + workAreas);
	}

	public WorkAreaDao getWorkAreaDao() {
		return workAreaDao;
	}

	public void setWorkAreaDao(WorkAreaDao workAreaDao) {
		this.workAreaDao = workAreaDao;
	}

	@Override
	public List<WorkArea> getAllWorkAreas() {
		
	//s	workAreas = workAreaDao.select();
		
		if (workAreas.isEmpty()) {
			System.out.println("MapServiceImpl.getAllWorkAreas()" + " EMPTY");
			WorkArea area1 = new WorkArea();
			area1.setAreaName("Tunisia");
			area1.setCountry("Tunisia");
			area1.setxPosition(31.6);
			area1.setyPosition(31.6);
			area1.setZoomLevel(10);
			area1.setState("");
			area1.setContinent("Africa");
			
			WorkArea workArea = workAreaDao.save(area1);
			workAreaDao.save(workArea);
			
			System.out.println("MapServiceImpl.getAllWorkAreas() id  = " + workArea.getId() );
			workAreas.add(workArea);
			
		}

		//workAreas = workAreaDao.select();
		System.out.println("MapServiceImpl.init()" + workAreas);
		return workAreas;
	}

}
