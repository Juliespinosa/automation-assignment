package tests;

import org.testng.annotations.Test;

import pageObjects.ReschedulePage;

public class RescheduleMeetingTest {

	@Test()
	public void rescheduleMeeting() {
		ReschedulePage reschedulePage = new ReschedulePage();
		reschedulePage.goTo().nextMonth().selectDay(9).selectAvailability(3).selectVideoCall().clickRescheduleButton()
				.confirm();
	}

}
