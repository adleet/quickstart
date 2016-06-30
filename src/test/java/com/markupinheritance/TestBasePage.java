package com.markupinheritance;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.markupinheritance.MarkupInheritanceApplication;
import com.markupinheritance.Page1;

/**
 * Simple test using the WicketTester
 */
public class TestBasePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		tester = new WicketTester(new MarkupInheritanceApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(Page1.class);

		//assert rendered page class
		tester.assertRenderedPage(Page1.class);
	}
}
