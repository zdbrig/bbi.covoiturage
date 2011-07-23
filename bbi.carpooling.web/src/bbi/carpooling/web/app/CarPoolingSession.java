package bbi.carpooling.web.app;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.Session;

import bbi.carpooling.model.map.WorkArea;
import bbi.carpooling.model.user.CPUser;

public class CarPoolingSession extends Session {

	protected CarPoolingSession(Application application, Request request) {
		super(application, request);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CPUser cpUser;
	private WorkArea workArea;

	@Override
	public void cleanupFeedbackMessages() {
		// TODO Auto-generated method stub

	}

	public void setCpUser(CPUser cpUser) {
		this.cpUser = cpUser;
	}

	public CPUser getCpUser() {
		return cpUser;
	}

	public void setWorkArea(WorkArea workArea) {
		this.workArea = workArea;
	}

	public WorkArea getWorkArea() {
		return workArea;
	}

}
