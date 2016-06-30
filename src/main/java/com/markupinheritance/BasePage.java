package com.markupinheritance;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public abstract class BasePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public BasePage() {
		add(new BookmarkablePageLink<Object>("page1", Page1.class));
		add(new BookmarkablePageLink<Object>("page2", Page2.class));
		add(new Label("footer", "This is in the footer"));
	}
}
