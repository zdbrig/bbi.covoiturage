package bbi.carpooling.web.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Session;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

import bbi.carpooling.model.user.CPUser;
import bbi.carpooling.web.app.CarPoolingSession;

public class ProfilePanel extends Panel {

	public ProfilePanel(String id) {
		super(id);
		setOutputMarkupId(true);
		CarPoolingSession session = (CarPoolingSession) Session.get();
		CPUser cpUser = session.getCpUser();

		List tabs = new ArrayList();
		tabs.add(new AbstractTab(new Model("General Informations")) {
			public Panel getPanel(String panelId) {
				return new GenInfoTabPanel(panelId);
			}
		});

		if (cpUser.getCpUserInfo().isMotorized()) {
			tabs.add(new AbstractTab(new Model("My Car")) {
				public Panel getPanel(String panelId) {
					return new CarTabPanel(panelId);
				}
			});
		}

		tabs.add(new AbstractTab(new Model("My Prefrences")) {
			public Panel getPanel(String panelId) {
				return new PrefrencesTabPanel(panelId);
			}
		});

		add(new AjaxTabbedPanel("tabs", tabs));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
