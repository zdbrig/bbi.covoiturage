package bbi.carpooling.web.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import bbi.carpooling.model.user.CPUser;
import bbi.carpooling.model.user.CPUserInfo.Civility;
import bbi.carpooling.service.api.user.IUserService;
import bbi.carpooling.web.pages.ErrorPanel;

/**
 * @author bacem
 */
public class UserPanel extends Panel {
	@SpringBean(name = "userService")
	private IUserService userService;

	public UserPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		CPUser cpUser = userService.createUser();
		Form<CPUser> form = new Form<CPUser>("form", new Model<CPUser>(cpUser)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				CPUser cpUser = getModelObject();
				String msge = "";
				msge = userService.validateUserInfo(getModelObject());
				if (msge != "" & msge != null)
					UserPanel.this.addOrReplace(new ErrorPanel("errorPanel",
							msge));
				else {
					try {
						userService.saveUser(cpUser);

						// getPage().addOrReplace(new
						// ClientPage(DetailClientPage.this.getId()));
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}

					setResponsePage(getPage().getClass());
				}

			}
		};

		final TextField loginTextField = new TextField("login", new PropertyModel(
				form.getModelObject(), "login"));
		form.add(loginTextField);
		AjaxLink<CPUser> validateLogin = new AjaxLink<CPUser>("validatelogin") {
			private static final long serialVersionUID = 1L;

			
			@Override
			public void onClick(AjaxRequestTarget arg0) {
				System.out.println((String) loginTextField.getModel().getObject());
				boolean isAvailable = userService.checkLoginAvailibility((String) loginTextField.getModel().getObject());
				if (isAvailable = false) {
					UserPanel.this.addOrReplace(new ErrorPanel("errorPanel",
							"* Login already used !"));
				}
			}
		};
		form.add(validateLogin);
		form.add(new TextField("pwd", new PropertyModel(form.getModelObject(),
				"password")));

		/*
		 * info générales
		 */
		// choices in radio button
		final List<String> civil = Arrays
				.asList(new String[] { "Mr", "Mm", "M" });

		RadioChoice<Civility> hostingType = new RadioChoice<Civility>(
				"civility", new PropertyModel(form.getModelObject()
						.getCpUserInfo(), "civility"), Arrays.asList(Civility
						.values()));
		hostingType.setChoiceRenderer(new IChoiceRenderer<Civility>() {

			@Override
			public Object getDisplayValue(Civility civ) {
				return civil.get(civ.ordinal());
			}

			@Override
			public String getIdValue(Civility civ, int i) {

				return civil.get(i);
			}
		});
		form.add(hostingType);
		form.add(new TextField("firstname", new PropertyModel(form
				.getModelObject().getCpUserInfo(), "firstName")));
		form.add(new TextField("lastname", new PropertyModel(form
				.getModelObject().getCpUserInfo(), "lastName")));
		form.add(new TextField("email", new PropertyModel(form.getModelObject()
				.getCpUserInfo(), "eMail")));
		form.add(new TextField("mobilenumber", new PropertyModel(form
				.getModelObject().getCpUserInfo(), "mobileNumber")));
		List<Integer> typesMvts = new ArrayList<Integer>();
		int i = 1911;
		Calendar c = Calendar.getInstance();

		int y = c.get(Calendar.YEAR);

		while (y - i >= 18) {
			typesMvts.add(i);
			i++;
		}
		form.add(new DropDownChoice<Integer>("year",
				new PropertyModel<Integer>(form.getModelObject()
						.getCpUserInfo(), "yearOfBearth"), typesMvts));
		final CheckBox chk0 = new CheckBox("motorized", new PropertyModel(form
				.getModelObject().getCpUserInfo(), "motorized"));
		form.add(chk0);

		add(form);
		addOrReplace(new ErrorPanel("errorPanel", ""));
		Link backLink = new Link("cancel") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				// getPage().addOrReplace(new
				// ClientPage(DetailClientPage.this.getId()));
				// setResponsePage(ClientPage.class);
			}
		};
		add(backLink);
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IUserService getUserService() {
		return userService;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
