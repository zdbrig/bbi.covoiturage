package bbi.carpooling.web.test;

import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import bbi.carpooling.model.user.CPUser;
import bbi.carpooling.service.api.user.IUserService;
import bbi.carpooling.web.app.CarPoolingSession;
import bbi.carpooling.web.pages.ErrorPanel;

public class SignInPanel  extends Panel {
	@SpringBean(name = "userService")
	private IUserService userService;

	public SignInPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		CPUser cpUser = userService.createUser();
		Form<CPUser> form = new Form<CPUser>("form", new Model<CPUser>(cpUser)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				CPUser cpUser = getModelObject();
				String msge = "";
				cpUser = userService.getUser(cpUser.getLogin(), cpUser.getPassword());
				if (cpUser== null){
					 msge = "* Wrong login or password!";
					 SignInPanel.this.addOrReplace(new ErrorPanel("errorPanel",
								msge));
				}
					
				else {
					try {
						CarPoolingSession session = (CarPoolingSession) Session.get();
						session.setCpUser(cpUser);
						getPage()
								.addOrReplace(
										new ProfilePanel(
												SignInPanel.this.getId()));
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}

					//setResponsePage(getPage().getClass());
				}

			}
		};

		final TextField loginTextField = new TextField("login",
				new PropertyModel(form.getModelObject(), "login"));
		form.add(loginTextField);
		
		form.add(new TextField("pwd", new PropertyModel(form.getModelObject(),
				"password")));
		add(form);
		addOrReplace(new ErrorPanel("errorPanel", ""));
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
