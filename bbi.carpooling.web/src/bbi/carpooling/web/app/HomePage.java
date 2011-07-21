package bbi.carpooling.web.app;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.PageLink;

import bbi.carpooling.web.test.PageContainer;

/**
 * @author bacem
 */
public class HomePage extends WebPage {

	public HomePage() {
		
		add(new PageLink("pagecontainer" , PageContainer.class));

//		add(HeaderContributor.forJavaScript(OpenLayers.class, "OpenLayers.js"));
		
//		add(HeaderContributor.forJavaScript(OpenLayers.class, "multimap.js"));
		
//		add(HeaderContributor.forCss(OpenLayers.class,"style.css"));
	}
}
