package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReschedulePage {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	public ReschedulePage() {
		driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class*='__right__4ivHA']")
	WebElement nextMonth;
	
	@FindBy(css = "div[data-testid*='calendar-day']")
	List<WebElement> days;
	
	@FindBy(css = "div[data-testid*='availability']")
	List<WebElement> availabilities;
	
	@FindBy(className = "kIglNN")
	List<WebElement> callType;
	
	@FindBy(css = ".ZUIButton--primary.ZUIButton--medium")
	WebElement rescheduleButton;
	
	@FindBy(className = "styles_confirmationSchedule__cta_confirm__bv2up")
	WebElement confirmButton;
	
	public ReschedulePage nextMonth() {
		waitForElementToAppear(By.className("schedule-dashboard__title"));
		nextMonth.click();
		return this;
	}
	
	public ReschedulePage selectDay(int day) {
		days.get(day).click();
		return this;
	}
	
	public ReschedulePage selectAvailability(int availability) {
		availabilities.get(availability).click();
		return this;
	}
	
	public ReschedulePage selectPhoneCall() {
		callType.get(0).click();
		return this;
	}
	
	public ReschedulePage selectVideoCall() {
		callType.get(1).click();
		return this;
	}
	
	public ReschedulePage clickRescheduleButton() {
		rescheduleButton.click();
		waitForElementToAppear(By.className("modal-schedule-profile"));
		return this;
	}
	
	public ReschedulePage confirm() {
		confirmButton.click();
		return this;
	}
	
	public void waitForElementToAppear(By findBy) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public ReschedulePage goTo() {
		driver.get("https://portal-test.zoefin.com/reschedule/66965aa0-9c17-11ed-b52a-53af9ee871d5");
		return this;
	}

}
