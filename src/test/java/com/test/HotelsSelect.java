package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsSelect extends BaseClass {
	public HotelsSelect() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "radiobutton_0")
	private WebElement SelectHotel;
	@FindBy(id = "continue")
	private WebElement btnConfirmHotel;
	public WebElement getSelectHotel() {
		return SelectHotel;
	}
	public WebElement getBtnConfirmHotel() {
		return btnConfirmHotel;
	}
	public void selectHotels() {
		clickBtn(SelectHotel);
		clickBtn(btnConfirmHotel);
	}
}
