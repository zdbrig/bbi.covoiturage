package bbi.carpooling.web.test;

import org.apache.wicket.markup.html.WebPage;

/**
 * @author bacem
 */
public class PageContainer extends WebPage {

	
	public PageContainer() {
		
		//add(new UserPanel("userpanel"));
		add(new ProfilePanel("userpanel"));
	}
}

