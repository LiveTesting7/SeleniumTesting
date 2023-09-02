package com.Pojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bse.BaseClass;

public class MynthraPojo extends BaseClass {

	public MynthraPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "mobileNumberPass")
	private WebElement phNo;

	@FindBy(xpath = "//input[@class='form-control has-feedback']")
	private WebElement pass;
	@FindBy(xpath = "//button[text()='LOGIN']")
	private WebElement logIn;

	public WebElement getphNo() {
		return phNo;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLogIn() {
		return logIn;
	}

}
