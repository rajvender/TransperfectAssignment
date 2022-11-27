package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchPage {
	WebDriver driver;

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='onetrust-button-group']")
	WebElement cookiebutton;

	public void goTo() {

		driver.get("https://wahoofitness.com/");

	}

	public void acceptcookie() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cookiebutton.click();

	}

}
