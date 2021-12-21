package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelOrder extends BaseClass {
	public CancelOrder() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[text()='Booked Itinerary']" )
	private WebElement btnItinerary;
	@FindBy(id = "order_id_text")
	private WebElement txtOrderedNo;
	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	@FindBy(xpath = "//input[@type='button']")
	private WebElement btnCancel;
	public WebElement getItinerary() {
	return btnItinerary;
	}
	public WebElement txtOrderedNo() {
		return txtOrderedNo;
	}
	public WebElement getBtnGo() {
		return btnGo;
	}
	public WebElement getBtnCancel() {
		return btnCancel;
	}
	public void OrderCancellation(String OrderedNo) {
		clickBtn(btnItinerary);
		typData(txtOrderedNo(), OrderedNo);
		clickBtn(btnGo);
		clickBtn(btnCancel);
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
}
