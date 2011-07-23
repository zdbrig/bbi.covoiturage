package bbi.carpooling.web.test;

import org.apache.wicket.Page;
import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author bacem
 */
public class PageContainer extends WebPage {

	public PageContainer(final PageReference modalWindowPage,
			final ModalWindow window) {

		 add(new SignInPanel("signinpanel"));
		 //add(new UserPanel("userpanel"));

	}

	// add(new ProfilePanel("userpanel",null));

}
