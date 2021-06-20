package TestPackg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestNG {
	
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	@Parameters({"username","password"})
	public void test1(String uname, String pass) {

		WebElement LoginLink = driver.findElement(By.linkText("Log in"));

		LoginLink.click();

		WebElement UserName = driver.findElement(By.name("user_login"));

		UserName.sendKeys(uname);

		WebElement Password = driver.findElement(By.id("password"));

		Password.sendKeys(pass);

		WebElement Rememberme = driver.findElement(By.className("rememberMe"));

		Rememberme.click();

		WebElement Login = driver.findElement(By.name("btn_login"));

		Login.click();

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
