package com.markupinheritance;

import org.apache.wicket.markup.html.basic.Label;

public class Page2 extends BasePage {
	private static final long serialVersionUID = 1L;

	public Page2() {
		add(new Label("label2", "This is in the subclass Page2"));
	}
}