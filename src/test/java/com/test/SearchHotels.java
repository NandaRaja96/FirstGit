package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotels extends BaseClass {
	public SearchHotels() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "location")
	private WebElement dDnLocation;
	@FindBy(id = "hotels")
	private WebElement dDnHotels;
	@FindBy(id = "room_type")
	private WebElement dDnRoomType;
	@FindBy(id = "room_nos")
	private WebElement dDnNoOfRooms;
	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement dDnAdultsPerRoom;
	@FindBy(id = "child_room")
	private WebElement dDnChildPerRoom;
	@FindBy(id = "Submit")
	private WebElement btnSubmit;
	public WebElement getdDnLocation() {
		return dDnLocation;
	}
	public WebElement getdDnHotels() {
		return dDnHotels;
	}
	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}
	public WebElement getdDnNoOfRooms() {
		return dDnNoOfRooms;
	}
	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}
	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}
	public WebElement getdDnAdultsPerRoom() {
		return dDnAdultsPerRoom;
	}
	public WebElement getdDnChildPerRoom() {
		return dDnChildPerRoom;
	}
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	public void HotelSearch(String Location,String Hotels,String RoomType,String NoOfRooms,String CheckInDate,String CheckOutDate,String AdultsPerRoom,String ChildPerRoom) {
	SltOptions(getdDnLocation(), Location);	
	SltOptions(getdDnHotels(), Hotels);
	SltOptions(getdDnRoomType(), RoomType);
	SltOptions(getdDnNoOfRooms(), NoOfRooms);
	typData(getTxtCheckInDate(), CheckInDate);
	typData(getTxtCheckOutDate(), CheckOutDate);
	SltOptions(getdDnAdultsPerRoom(), AdultsPerRoom);
	SltOptions(getdDnChildPerRoom(), ChildPerRoom);
	clickBtn(btnSubmit);
	}
}
