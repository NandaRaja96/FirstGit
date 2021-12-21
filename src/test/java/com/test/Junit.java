package com.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.Assert;

public class Junit extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		getDriver();
		loadUrl("http://adactinhotelapp.com/BookedItinerary.php");
		maximize();
	}

	@AfterClass
	private void afterClass() {
		close();
	}

	@Test
	private void cancelBooking() throws InterruptedException, IOException {
		POM a = new POM();
		a.loginPage(getData(1, 0),getData(1, 1));
		SearchHotels b = new SearchHotels();
		b.HotelSearch(getData(1, 2),getData(1, 3),getData(1, 4),getData(1, 5),getData(1, 6),getData(1, 7),getData(1, 8),
				getData(1, 9));
		HotelsSelect c = new HotelsSelect();
		c.selectHotels();
		BookHotel d = new BookHotel();
		d.HotelBook(getData(1, 10),getData(1, 11),getData(1, 12),getData(1, 13),getData(1, 14),getData(1, 15),getData(1, 16),getData(1, 17));
		BookingConfirmation e = new BookingConfirmation();
		Thread.sleep(10000);
		String orderID = e.getOrderNo().getAttribute("value");
		CancelOrder f = new CancelOrder();
		f.OrderCancellation(orderID);
		WebElement errorMsg = findElementById("search_result_error");
		String text = errorMsg.getText();
		verification("order cancelled","The booking has been cancelled.", text);

	}
}
