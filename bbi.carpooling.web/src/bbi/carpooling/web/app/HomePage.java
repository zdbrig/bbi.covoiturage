package bbi.carpooling.web.app;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.behavior.AbstractBehavior;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.WindowClosedCallback;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;

import bbi.carpooling.model.map.WorkArea;
import bbi.carpooling.web.test.PageContainer;
import bbi.carpooling.web.test.WorkAreasPage;

/**
 * @author bacem
 */
public class HomePage extends WebPage {

	public HomePage() {

		add(new AbstractBehavior() {
			@Override
			public void renderHead(IHeaderResponse response) {
				super.renderHead(response);
				response.renderJavascript(GoogleMapGenerator.createDynamicGoogleMapJs(),
						"google_map_js");
			}
		});

		final ModalWindow modal1;
		add(modal1 = new ModalWindow("loginModal"));

		modal1.setCookieName("loginModal-1");

		modal1.setPageCreator(new ModalWindow.PageCreator() {
			public Page createPage() {
				return new PageContainer(HomePage.this.getPageReference(),
						modal1);
			}
		});

		add(new AjaxLink<Void>("showloginModal") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				modal1.show(target);
			}
		});
		modal1.setWindowClosedCallback(new WindowClosedCallback() {

			@Override
			public void onClose(AjaxRequestTarget target) {
				setResponsePage(HomePage.class);

			}
		});

		final ModalWindow wsModal;
		add(wsModal = new ModalWindow("wsModal"));

		wsModal.setContent(new WorkAreasPage(wsModal.getContentId()));
		wsModal.setTitle("List of work spaces");
		wsModal.setCookieName("modal-2");

		add(new AjaxLink<Void>("showwsModal") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				wsModal.show(target);
			}
		});

		// add(HeaderContributor.forJavaScript(OpenLayers.class,
		// "OpenLayers.js"));

		// add(HeaderContributor.forJavaScript(OpenLayers.class,
		// "multimap.js"));

		// add(HeaderContributor.forCss(OpenLayers.class,"style.css"));
	}

	

}
