package bbi.carpooling.web.pages;

import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class ErrorPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public ErrorPanel(String id, String listErrors) {
		super(id);
		add(new MultiLineLabel("Error",new Model(listErrors)));
		
	}

}
