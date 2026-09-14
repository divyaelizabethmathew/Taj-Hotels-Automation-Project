package testpkg;

import org.testng.annotations.Test;

import basepkg.TajBaseClass;
import pagepkg.HomePage;

public class HomePageTest extends TajBaseClass{
	
	@Test
	public void homeTest() 
	{
		test = extent.createTest("Home Page");
		HomePage home = new HomePage(driver);
		home.titleVeri();
		home.logoVeri();
		home.linkCount();
		home.destinationMthd("Goa");
	}

}
