package DavidAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.landingPage;
import resources.Base;



public class ValidatePage extends Base{

	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.manage().window().maximize();
		log.info("Browser window is maximized");

		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");

	}
	
	
	@Test
	public void BasePageNavigation() throws IOException
	{
		driver.navigate().refresh();
		log.info("Page refreshed");
		landingPage l = new landingPage(driver);
		
		//compare the text from the browser with actual value
		Assert.assertTrue(l.getNavBar().isDisplayed());
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");

		
		
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
	}
	
}
