package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class landingPage{

	WebDriver driver;
	By signin = By.cssSelector("a[href*='sign_in']"); 
	By title = By.cssSelector(".text-center>h2 ");
	By navBar = By.cssSelector(".container>nav>ul");
	
	public landingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	} 
}
