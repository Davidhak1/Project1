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



public class HomePage extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void BasePageNavigation(String un, String psw, String type) throws IOException
	{
		driver.get(prop.getProperty("url"));
		driver.navigate().refresh();
		landingPage l = new landingPage(driver);
		l.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getemail().sendKeys(un);
		lp.getpassword().sendKeys(psw);
		lp.getloginbutton().click();
		log.info(type);
//		Assert.assertTrue(false);
		
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "Restricteduser@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
	
		data[1][0] = "Nonrestricteduser@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "Non Restricted User";
		
		return data;
	 }
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	}
	
}
