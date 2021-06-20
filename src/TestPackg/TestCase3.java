package TestPackg;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test(priority=2)
	public void test1() {
		System.out.println("New test example for before group");
	}
	
	@Test(priority=1)
	public void test2() {
		System.out.println("New test example for before test");
	}
	
	@Test(priority=0)
	public void test3() {
		System.out.println("New test example for before group");
	}
}
