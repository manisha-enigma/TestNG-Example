package TestPackg;
import org.testng.annotations.Test;

public class TestCase1 {

	@Test(groups= {"Sanity"})
	public void LoginTest() {
		System.out.println("Login Test case");
	}

	@Test(groups= {"Sanity"})
	public void SignUpTest() {
		System.out.println("Signup Test case");
	}
	
	@Test(groups= {"Regression"})
	public void RandomName() {
		System.out.println("Random Test case");
	}
	
	@Test
	public void NewNametest1() {
		System.out.println("New Name test one Test case");
	}

	
	@Test(groups= {"Regression"})
	public void NewName() {
		System.out.println("New Name Test case");
	}
	
	@Test(groups= {"Regression"})
	public void NewNametest() {
		System.out.println("New Name test test Test case");
	}


}
