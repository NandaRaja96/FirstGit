package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation extends BaseClass {
	public BookingConfirmation() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "order_no")
	public WebElement orderNo;

	public WebElement getOrderNo() {
		return orderNo;
	}
	
	private void orderNumber() {
	getOrderNo();	
	}
	
}
