package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LaunchPage;
import org.openqa.selenium.WebElement;

public class Addproduct {
	WebDriver driver;
	

	public Addproduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Run']")
	WebElement categorgy;

	@FindBy(xpath = "//ul[@class='products-grid']/li")
	List<WebElement> li;

	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement addtocartbutton;
	
	
	@FindBy(xpath="//div[@class='offers-container']")
	WebElement protectpurchasewindow;
	
	@FindBy(xpath="//button[text()='Protect my purchase']")
	WebElement protectpurchasebutton;
	
	public void selectcategory() {
		categorgy.click();

	}

	public void getproductlist() {

		int sizeoflist = li.size();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Random random = new Random();
		int randomProduct = random.nextInt(sizeoflist - 1);
		System.out.println(randomProduct);

		if (li.get(randomProduct).getText().contains("out of stock")) {
			li.get(randomProduct + 1).click();
			System.out.println(li.get(randomProduct + 1).getText());
		} else {
			System.out.println(li.get(randomProduct).getText());
			li.get(randomProduct).click();
		}
	}

	public void addtocart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addtocartbutton));
		addtocartbutton.click();
		if(protectpurchasewindow.isDisplayed()) {
			protectpurchasebutton.click();
			
		}
		
	}
}
