package com.markupinheritance;

import org.apache.wicket.markup.html.basic.Label;

public class Page1 extends BasePage {
	private static final long serialVersionUID = 1L;

	public Page1() {
		add(new Label("label1", "This is in the subclass Page1"));
	}
}