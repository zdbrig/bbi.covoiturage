package bbi.carpooling.web.test;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import bbi.carpooling.model.user.CPUser;
import bbi.carpooling.service.api.user.IUserService;
import bbi.carpooling.web.app.CarPoolingSession;
import bbi.carpooling.web.pages.ErrorPanel;

public class PrefrencesTabPanel extends Panel {

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

	public PrefrencesTabPanel(String id) {
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
					getPage().addOrReplace(new ProfilePanel("signinpanel"));
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
		};

		final List<String> pref = Arrays.asList(new String[] { "Yes", "No",
				"Indifferent" });

		final List<Boolean> prefValues = Arrays.asList(true, false, null);

		// Music
		RadioChoice<Boolean> hostingMusic = new RadioChoice<Boolean>(
				"musicChoice", new PropertyModel(form.getModelObject()
						.getCpUserPreferences(), "musicChoice"), prefValues);
		hostingMusic.setChoiceRenderer(new IChoiceRenderer<Boolean>() {

			@Override
			public Object getDisplayValue(Boolean civ) {
				System.out.println(civ);
				System.out.println(prefValues.indexOf(civ)+" indexOf(civ)");
				System.out.println(pref.get(0));
			   System.out.println(pref.get(1));
			   System.out.println(pref.get(2));
				if (civ == null) {
					return pref.get(2);
				} else
					return pref.get(prefValues.indexOf(civ));
			}

			@Override
			public String getIdValue(Boolean civ, int i) {
				return pref.get(i);
			}
		});
		form.add(hostingMusic);

		// Tabac
		RadioChoice<Boolean> hostingTabac = new RadioChoice<Boolean>(
				"tabacChoice", new PropertyModel(form.getModelObject()
						.getCpUserPreferences(), "tabacChoice"), prefValues);
		hostingTabac.setChoiceRenderer(new IChoiceRenderer<Boolean>() {

			@Override
			public Object getDisplayValue(Boolean civ) {
				if (civ == null) {
					return pref.get(2);
				} else
					return pref.get(prefValues.indexOf(civ));
			}

			@Override
			public String getIdValue(Boolean civ, int i) {

				return pref.get(i);
			}
		});
		form.add(hostingTabac);

		// Animal
		RadioChoice<Boolean> hostingAnimal = new RadioChoice<Boolean>(
				"animalChoice", new PropertyModel(form.getModelObject()
						.getCpUserPreferences(), "animalChoice"), prefValues);
		hostingAnimal.setChoiceRenderer(new IChoiceRenderer<Boolean>() {

			@Override
			public Object getDisplayValue(Boolean civ) {
				if (civ == null) {
					return pref.get(2);
				} else
					return pref.get(prefValues.indexOf(civ));
			}

			@Override
			public String getIdValue(Boolean civ, int i) {

				return pref.get(i);
			}
		});
		form.add(hostingAnimal);

		// Discussions
		RadioChoice<Boolean> hostingDiscussions = new RadioChoice<Boolean>(
				"discussionChoice", new PropertyModel(form.getModelObject()
						.getCpUserPreferences(), "discussionChoice"),
				prefValues);
		hostingDiscussions.setChoiceRenderer(new IChoiceRenderer<Boolean>() {

			@Override
			public Object getDisplayValue(Boolean civ) {
				if (civ == null) {
					return pref.get(2);
				} else
					return pref.get(prefValues.indexOf(civ));
			}

			@Override
			public String getIdValue(Boolean civ, int i) {
				// FIXME : valeur "indifférent" n'est pas gérée
				return pref.get(i);
			}
		});
		form.add(hostingDiscussions);

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
