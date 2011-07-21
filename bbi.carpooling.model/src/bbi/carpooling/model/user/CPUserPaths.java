package bbi.carpooling.model.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import bbi.carpooling.model.BaseBean;
import bbi.carpooling.model.map.Path;

@Entity
public class CPUserPaths extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CPUser cpUser;
	private Set<Path> pathList;

	public void setCpUser(CPUser cpUser) {
		this.cpUser = cpUser;
	}

	@OneToOne
	public CPUser getCpUser() {
		return cpUser;
	}

	public void setPathList(Set<Path> pathList) {
		this.pathList = pathList;
	}

	@OneToMany(mappedBy = "cpUserPaths", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<Path> getPathList() {
		return pathList;
	}

}
