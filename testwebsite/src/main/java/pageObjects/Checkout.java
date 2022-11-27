package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
WebDriver driver;

public Checkout(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
WebElement checkoutoutbutton;


public void checkout() {
	checkoutoutbutton.click();
	
}



}

