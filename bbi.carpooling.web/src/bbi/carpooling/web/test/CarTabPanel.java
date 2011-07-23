package bbi.carpooling.web.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.wicket.Session;
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
import bbi.carpooling.model.user.Car.Comfort;
import bbi.carpooling.service.api.user.IUserService;
import bbi.carpooling.web.app.CarPoolingSession;
import bbi.carpooling.web.pages.ErrorPanel;

public class CarTabPanel extends Panel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SpringBean(name = "userService")
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public CPUser getCpUser() {
		return cpUser;
	}

	public void setCpUser(CPUser cpUser) {
		this.cpUser = cpUser;
	}

	CarPoolingSession session = (CarPoolingSession) Session.get();
	CPUser cpUser = session.getCpUser();

	public CarTabPanel(String id)
	{
		super(id);
		setOutputMarkupId(true);
		Form<CPUser> form = new Form<CPUser>("form", new Model<CPUser>(cpUser)) {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				CPUser cpUser = getModelObject();
					try {
						userService.saveUser(cpUser);

						session.setCpUser(cpUser);
						getPage()
								.addOrReplace(
										new ProfilePanel(
												"signinpanel"));
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}

					//setResponsePage(getPage().getClass());
				

			}
		};
		//model & brand
		form.add(new TextField("brand", new PropertyModel(form
				.getModelObject().getCar(), "brand")));
		form.add(new TextField("model", new PropertyModel(form
				.getModelObject().getCar(), "model")));
		// Comfort
		final List<String> comfort = Arrays
				.asList(new String[] { "BASIC", "NORMAL", "COMFORTABLE", "LUXURY" });

		RadioChoice<Comfort> hostingType = new RadioChoice<Comfort>(
				"comfort", new PropertyModel(form.getModelObject()
						.getCar(), "comfort"), Arrays.asList(Comfort
						.values()));
		hostingType.setChoiceRenderer(new IChoiceRenderer<Comfort>() {

			@Override
			public Object getDisplayValue(Comfort cmfrt) {
				return comfort.get(cmfrt.ordinal());
			}

			@Override
			public String getIdValue(Comfort cmfrt, int i) {

				return comfort.get(i);
			}
		});
		form.add(hostingType);
		//Nbr of places
		ArrayList<Integer> numberOfPlaces = new ArrayList<Integer>();
		int i = 1;

		while ( i <= 5) {
			numberOfPlaces.add(i);
			i++;
		}
		form.add(new DropDownChoice<Integer>("numberOfPlaces",
				new PropertyModel<Integer>(form.getModelObject()
						.getCar(), "numberOfPlaces"), numberOfPlaces));
		
		
		//Color
		form.add(new TextField("color", new PropertyModel(form.getModelObject()
				.getCar(), "color")));
		

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
};

