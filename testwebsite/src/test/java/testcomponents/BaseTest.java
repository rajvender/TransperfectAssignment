package testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Addproduct;
import pageObjects.Checkout;
import pageObjects.LaunchPage;

public class BaseTest {
	public WebDriver driver;
	public LaunchPage launchpage;
	public Addproduct addprodut;
	public Checkout checkout;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		;

		return driver;

	}

	@BeforeTest(alwaysRun = true)
	public void launchApplication() throws IOException, InterruptedException {
		driver = initializeDriver();
		launchpage = new LaunchPage(driver);
		checkout=new Checkout(driver);
		launchpage.goTo();

		// return launchpage;

	}

	@Test
	public void test1_acceptcookie() {
		launchpage.acceptcookie();
	}

	@Test
	public void test2_selectcat() throws IOException {
		addprodut = new Addproduct(driver);
		addprodut.selectcategory();

	}

	@Test
	public void test3_selectproduct() {
		addprodut.getproductlist();

	}
	
	@Test
	public void test4_addtocartbuttonclick() {
		addprodut.addtocart();
		
	}
	
	@Test
	public void test5_checkoutbuttonclick() {
		checkout.checkout();
	}
	
	
}
