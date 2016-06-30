package com.ajaxcounter;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

public class CounterZonderAjax extends WebPage {
	private static final long serialVersionUID = 1L;

	public CounterZonderAjax() {
		Model<Integer> model = new Model<Integer>() {
			private int counter = 0;

			public Integer getObject() {
				return counter++;
			}
		};
		add(new Link("link") {
			public void onClick() {
				// do nothing.
			}
		});
		add(new Label("counter", model));
	}

}