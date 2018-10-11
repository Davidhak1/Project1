package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LoginPage{

	public WebDriver driver;
	By email = By.id("user_email"); 
	By password = By.id("user_password");
	By loginbutton = By.xpath("//input[@type='submit']");
	
	
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getloginbutton()
	{
		return driver.findElement(loginbutton);
	}
	
	
}
