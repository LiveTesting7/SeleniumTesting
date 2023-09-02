package org.stepDefinition4;

import java.util.List;
import java.util.Map;

import com.Pojo.MynthraPojo;
import com.bse.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Myt_challenges extends BaseClass {
	MynthraPojo mynthraPojo;
	@Given("To open browser and maximize window")
	public void toOpenBrowserAndMaximizeWindow() {
		launchBrowser();
		maximizeWindow();

	}

	@When("To launch the url")
	public void toLaunchTheUrl() {
		urlLaunching("https://www.myntra.com/login/password");
	}

	@When("To enter registered PhoneNumber in PhoneNumber field")
	public void toEnterRegisteredPhoneNumberInPhoneNumberField(DataTable d) throws InterruptedException {
		Thread.sleep(5000);
		Map<String, String> asMap = d.asMap(String.class, String.class);
		mynthraPojo = new MynthraPojo();
		sendText(mynthraPojo.getphNo(), asMap.get("Number1"));
	}

	@When("To enter password in Password field")
	public void toEnterPasswordInPasswordField(DataTable d) {
		List<Map<String, String>> asMaps = d.asMaps();
		mynthraPojo = new MynthraPojo();
		sendText(mynthraPojo.getPass(), asMaps.get(1).get("Password2"));
	}

	@When("To click login button")
	public void toClickLoginButton() {
		mynthraPojo = new MynthraPojo();
		clickElement(mynthraPojo.getLogIn());
	}

	@Then("To close the browser")
	public void toCloseTheBrowser() {
		closeBrowser();
	}
}
