package stepDefinition;

import java.io.IOException;

import PageObject.LoginPage;
import PageObject.PortalHomePage;
import PageObject.landingPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import resources.Base;

public class stepDefinition extends Base{
	

@Given("Initialize the browser with chrome")
public void initialize_the_browser_with_chrome() throws IOException {

	driver = initializeDriver();
}

@Given("^Navigate to \"([^\"]*)\" site$")
public void navigate_to_something_site(String url) throws Throwable {
	driver.get(url);
	driver.navigate().refresh();}


@Given("Click on Login link in home page to land on Secure sign in page")
public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_page() {

	landingPage l = new landingPage(driver);
	l.getLogin().click();}


@When("^User enters (.+) and (.+) and logs in$")
public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
	LoginPage lp = new LoginPage(driver);
	lp.getemail().sendKeys(username);
	lp.getpassword().sendKeys(password);
	lp.getloginbutton().click();

}

@Then("Verify that user is successfully logged in")
public void verify_that_user_is_successfully_logged_in() {

	PortalHomePage php = new PortalHomePage(driver);
	Assert.assertTrue(php.getSearchbox().isDisplayed());
	
}

@Then("close browsers")
public void close_browsers() {
    driver.quit();
}
}
