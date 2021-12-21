package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel extends BaseClass {
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "address")
	private WebElement txtAddress;
	@FindBy(id = "cc_num")
	private WebElement txtCCNum;
	@FindBy(id = "cc_type")
	private WebElement dDnCCType;
	@FindBy(id = "cc_exp_month")
	private WebElement dDnCCExpMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement dDnCCExpYear;
	@FindBy(id = "cc_cvv")
	private WebElement txtCVV;
	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	public WebElement getTxtFirstName() {
		return txtFirstName;
	}
	public WebElement getTxtLastName() {
		return txtLastName;
	}
	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getTxtCCNum() {
		return txtCCNum;
	}
	public WebElement getdDnCCType() {
		return dDnCCType;
	}
	public WebElement getdDnCCExpMonth() {
		return dDnCCExpMonth;
	}
	public WebElement getdDnCCExpYear() {
		return dDnCCExpYear;
	}
	public WebElement gettxtCVV() {
		return txtCVV;
	}
	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	public void HotelBook(String FirstName,String LastName,String Address,String CCNum,String CCType,String CCExpMonth,String CCExpYear,String CVV) {
		typData(getTxtFirstName(),FirstName);
		typData(getTxtLastName(), LastName);
		typData(getTxtAddress(), Address);
		typData(getTxtCCNum(), CCNum);
		SltOptions(getdDnCCType(), CCType);
		SltOptions(getdDnCCExpMonth(), CCExpMonth);
		SltOptions(getdDnCCExpYear(), CCExpYear);
		typData(gettxtCVV(), CVV);
		clickBtn(btnBookNow);
	}
}
