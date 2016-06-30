package com.fragments;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.Loop;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.panel.Fragment;

public class Fragments extends WebPage {

	public class Fragment1 extends Fragment { // subclass
		public Fragment1(String id, String markupId) { // constructor of the subclass
			
			// does the same as "Fragment("panel", fragmentId, Fragments.this)"
			super(id, markupId, Fragments.this);
			
			this.add(new Label("label", "Hello, World!"));
		}
	}

	public Fragments() { // constructor of Fragments
		Loop loop = new Loop("list", 5) {
			protected void populateItem(LoopItem item) {
				
				int index = item.getIndex() % 2 + 1;
				String fragmentId = "fragment" + index;
				
				if (index == 1) {
					item.add(new Fragment1("panel", fragmentId));
				} else {
					item.add(new Fragment("panel", fragmentId, Fragments.this));
				}
			}
		};
		this.add(loop);
	}
}