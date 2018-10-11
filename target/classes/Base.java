package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String brwName = prop.getProperty("browser");
	
	if(brwName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Davit\\Desktop\\David\\Selenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	else if(brwName.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Davit\\Desktop\\David\\Selenium\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Davit\\Desktop\\David\\Selenium\\Drivers\\iedriv"
				+ "erserver.exe");
		driver = new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
	
	public void getScreenshot(String methodName, int num) throws IOException 
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Davit\\Desktop\\Screenshots\\"+methodName+num+".screen.png"));
	}
}
