package com.ajaxcounter;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class CounterMetAjax extends WebPage {
	private static final long serialVersionUID = 1L;

	public CounterMetAjax() {
		Model<Integer> model = new Model<Integer>() {
			private int counter = 0;

			public Integer getObject() {
				return counter++;
			}
		};

		final Label label = new Label("counter", model);
		label.setOutputMarkupId(true); // Belangrijk. Deze heb je nodig!!!

		add(new AjaxFallbackLink("link") {
			// Belangrijk! Gebruik "AjaxRequestTarget" om je component aan toe te voegen!!!
			public void onClick(AjaxRequestTarget target) {
				if (target != null) {
					// target is only available in an Ajax request
					target.add(label);
				}
			}
		});
		add(label);
	}

}