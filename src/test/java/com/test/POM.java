package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM extends BaseClass {
	public POM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement txtUsername;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	public WebElement getTxtUsername() {
		return txtUsername;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void loginPage(String Username,String Password) {
		typData(getTxtUsername(), Username);
		typData(getTxtPassword(), Password);
		clickBtn(getBtnLogin());
		
	}
}
