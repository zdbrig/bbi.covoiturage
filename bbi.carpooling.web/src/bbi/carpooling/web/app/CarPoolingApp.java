package bbi.carpooling.web.app;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class CarPoolingApp extends WebApplication {

	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	
	@Override
	protected void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}
}
