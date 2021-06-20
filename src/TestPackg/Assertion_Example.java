package TestPackg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Assertion_Example {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	SoftAssert soft = new SoftAssert();
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	
		report = new ExtentReports("Extent_Manisha.html");
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void test1(String uname, String pass) {

		
		test = report.startTest("Login example 1");
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));

		LoginLink.click();
		
		test.log(LogStatus.PASS, "Successfully clicked on URL");
		WebElement UserName = driver.findElement(By.name("user_login"));

		UserName.sendKeys(uname);
		test.log(LogStatus.PASS, "Username added");

		WebElement Password = driver.findElement(By.id("password"));

		Password.sendKeys(pass);
		test.log(LogStatus.PASS, "Password entered");

		WebElement Rememberme = driver.findElement(By.className("rememberMe"));

		Rememberme.click();
		test.log(LogStatus.PASS, "Checked the Login remember checkbox");

		WebElement Login = driver.findElement(By.name("btn_login"));

		Login.click();
		test.log(LogStatus.PASS, "Clicked on Login button successfully");
		
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String ActMsg = error.getText();
		String ExpMsg = "The email or password does not exist";
		
		Assert.assertTrue(error.isDisplayed());
		
		soft.assertEquals(ActMsg, ExpMsg);
		
		try {
			Assert.assertEquals(ActMsg, ExpMsg);
			test.log(LogStatus.PASS, "Try block");
		}
		catch(Throwable e) {
			test.log(LogStatus.FAIL, "Catch block");
		}
		
	}
	
	@AfterMethod
	public void teardown() {
		
		
		report.endTest(test);
		report.flush();
		driver.quit();
		
		soft.assertAll();
	}

}
