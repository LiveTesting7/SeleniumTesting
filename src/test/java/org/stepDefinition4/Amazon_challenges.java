package org.stepDefinition4;

import io.cucumber.datatable.DataTable;

import java.util.List;

import com.Pojo.AmaonPojo;
import com.bse.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Amazon_challenges extends BaseClass {
	AmaonPojo amaonPojo;

	@Given("To open the chromeBrowser and maximize the window")
	public void to_open_the_chromeBrowser_and_maximize_the_window() {
		launchBrowser();
		maximizeWindow();
	}

	@When("User has to hit the Amazon login url correctly")
	public void user_has_to_hit_the_Amazon_login_url_correctly() {

		urlLaunching("https://www.amazon.in/");
	}

	@When("User has to hover and click the Hello signIn button")
	public void user_has_to_hover_and_click_the_Hello_signIn_button() {
		amaonPojo = new AmaonPojo();
		moveElement(amaonPojo.getSignInHover());
		clickElement(amaonPojo.getSignInHover());

	}

	@When("User has to pass the data in the email field")
	public void user_has_to_pass_the_data_in_the_email_field(DataTable d) {
		List<String> asList = d.asList();
		amaonPojo = new AmaonPojo();
		sendText(amaonPojo.getPhNo(), asList.get(1));

	}

	@When("User has to click the continue button")
	public void user_has_to_click_the_continue_button() {
		amaonPojo = new AmaonPojo();
		clickElement(amaonPojo.getCon());
	}

	@When("User has to pass the data in the password field")
	public void user_has_to_pass_the_data_in_the_password_field(DataTable d) {
		List<List<String>> asLists = d.asLists();
		amaonPojo = new AmaonPojo();
		sendText(amaonPojo.getPhNo(), asLists.get(1).get(1));
	}

	@When("User has to click the continue button again")
	public void user_has_to_click_the_continue_button_again() {
		amaonPojo = new AmaonPojo();
		clickElement(amaonPojo.getCon());
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
		closeBrowser();
	}

}
