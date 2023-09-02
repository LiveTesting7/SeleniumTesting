package org.stepDefinition4;

import com.bse.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends BaseClass{

	@Before(order = 1)
	private void Precondition() {
		launchBrowser();
		

	}
	
	@Before(order=2)
	private void precondition2() {
		maximizeWindow();

	}
	
	@After(order=2,value="@regression")
	private void postcondition2() {
		System.out.println("Sanity passed");

	}
	@After(order=1)
	private void postCondition() {
		closeBrowser();

	}
}
