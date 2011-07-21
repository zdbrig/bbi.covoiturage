package bbi.carpooling.web.app;

import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.ISessionSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class CarPoolingApp extends WebApplication {

	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}
	
	@Override
	public Session newSession(Request request, Response response) {
		
		return new CarPoolingSession(this, request);
	}

	
	@Override
	protected void init() {
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));
	}
	
	
}
