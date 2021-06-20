package SwagDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Example {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void Login() {

		WebElement UserName = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		UserName.sendKeys("standard_user");

		WebElement Password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		Password.sendKeys("secret_sauce");

		WebElement Login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		Login.click();

	}

	@Test(dependsOnMethods = "Login")
	public void addCart() {
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement addToCart = driver
				.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));
		addToCart.click();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void teardown() {
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);		
		driver.quit();
	}

}
