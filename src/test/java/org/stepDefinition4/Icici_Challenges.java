package org.stepDefinition4;

import java.util.List;

import com.Pojo.IciciPojo;
import com.bse.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Icici_Challenges extends BaseClass {
	IciciPojo iciciPojo;

	@Given("To open browser and maximize window")
	public void to_open_browser_and_maximize_window() {
		launchBrowser();
		maximizeWindow();

	}

	@When("To launch the url")
	public void to_launch_the_url() {
		urlLaunching(
				"https://infinity.icicibank.com/corp/AuthenticationController?"
				+ "FORMSGROUP_ID__=AuthenticationFG&__"
				+ "START_TRAN_FLAG__=Y&FG_BUTTONS__=LOAD&ACTION."
				+ "LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID="
				+ "ICI&ITM=nli_personalb_personal_login_btn&_gl="
				+ "1*30xkeg*_ga*MTgzMDcxOTY5Ni4xNjIwMDM5NDU0*_ga_"
				+ "SKB78GHTFV*MTYyODIzNDM4NC43Ny4xLjE2MjgyMzQ1MDQuMjc"
				+ ".&_ga=2.44076717.824095413.1693314735-1304496209.1693314735");

	}

	@When("To enter registered userId in Userid field")
	public void to_enter_registered_userId_in_Userid_field(DataTable d) throws InterruptedException {
		List<String> asList = d.asList();

		Thread.sleep(10000);
		iciciPojo = new IciciPojo();
//		switchFrame(iciciPojo.getIciciFrame());
		javaScriptClick(iciciPojo.getUserId());
		javaScriptSetValue(iciciPojo.getUserId(), asList.get(1));
	}

	@When("To enter password in Password field")
	public void to_enter_password_in_Password_field(DataTable d) {
		List<List<String>> asLists = d.asLists();
		iciciPojo = new IciciPojo();
		javaScriptSetValue(iciciPojo.getPass(), asLists.get(0).get(1));
	}

	@When("To click login button")
	public void to_click_login_button() {
		iciciPojo = new IciciPojo();
		System.out.println(iciciPojo.getLogIn().isDisplayed());
		clickElement(iciciPojo.getLogIn());
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeBrowser();

	}

}
