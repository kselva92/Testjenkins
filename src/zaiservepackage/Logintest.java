package zaiservepackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class Logintest {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
		
	    PageFactory.initElements(driver, Login.class);

		driver.get("http://demo.zaigoshop.com/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void test_one()

	// check with invalid user id and invalid password
	{
		Login.userName.sendKeys("name@nn.in");

		Login.password.sendKeys("pass");

		Login.login.click();

		String email_err = Login.email_err.getText();

		if (email_err.equals("These credentials do not match our records.")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}