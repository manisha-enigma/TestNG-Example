package TestPackg;
import org.testng.annotations.Test;

public class TestCase2 {
	
	@Test(groups= {"Regression"})
	public void testcase1() {
		System.out.println("Test case one");
	}
	
	@Test(groups= {"Sanity"})
	public void testcase2() {
		System.out.println("Test case two");
	}
}
