package bbi.carpooling.web.test;

import org.apache.wicket.PageReference;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.SimpleAttributeModifier;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

import bbi.carpooling.model.map.WorkArea;
import bbi.carpooling.service.api.map.IMapService;
import bbi.carpooling.web.app.CarPoolingSession;
import bbi.carpooling.web.app.HomePage;

/**
 * @author bacem
 */
public class WorkAreasPage extends WebPage {

	@SpringBean
	private IMapService mapService;

	public WorkAreasPage(final PageReference modalWindowPage,
			final ModalWindow window) {

		add(new ListView<WorkArea>("workaeras", mapService.getAllWorkAreas()) {

			@Override
			protected void populateItem(ListItem<WorkArea> item) {
				WorkArea workArea = item.getModelObject();
				item.add(new Label("workaeraname", workArea.getAreaName()));

				AjaxLink<WorkArea> wsLink = new AjaxLink<WorkArea>("workaeralink", item
						.getModel()) {

					@Override
					public void onClick(AjaxRequestTarget target) {
						((CarPoolingSession) Session.get())
								.setWorkArea(getModelObject());

						
						
						window.close(target);
						
						setResponsePage(HomePage.class);

					}

				};

				item.add(wsLink);

			}

		});

	}

	public IMapService getMapService() {
		return mapService;
	}

	public void setMapService(IMapService mapService) {
		this.mapService = mapService;
	}
}
