package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import drivers.Drivers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import xPaths.HomePage;
import xPaths.LoginPageXPaths;

public class LoginSteps {

	WebDriver driver = null;

	@Given("Open google chrome")
	public void open_google_chrome() {
		System.setProperty(Drivers.driverName, Drivers.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@And("Browse facebook.com")
	public void browse_facebook_com() {
		driver.navigate().to("https://www.facebook.com/");
	}

	@When("^User entries (.*) and (.*)$")
	public void user_entries_and_taseen(String phoneno, String password) {
		driver.findElement(By.xpath(LoginPageXPaths.userNameXPath)).sendKeys(phoneno);
		driver.findElement(By.xpath(LoginPageXPaths.passwordXPath)).sendKeys(password);
	}

	@And("Press login button")
	public void press_login_button() {
		driver.findElement(By.xpath(LoginPageXPaths.loginButtonXPath)).submit();
	}

	@Then("Facebook homepage will display")
	public void facebook_homepage_will_display() {
		String home = "";
		try {
			home = driver.findElement(By.xpath(HomePage.HOME_LINK)).getAttribute("aria-label");
			System.out.println(home);

		} catch (NoSuchContextException ex) {

		} finally {
			//driver.quit();
			Assert.assertTrue("Not on Home Page", home.equals("Home"));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@And("Click on whats on your maind span")
	public void click_on_whats_on_your_maind_span() {
	    driver.findElement(By.xpath(HomePage.STATUS_SPAN)).click();
	}
	
	@And("Type a status message")
	public void type_a_status_message() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement status = driver.switchTo().activeElement();
		status.sendKeys("Hello Friends! What's on your mind??");
	}
	
	@Then("Click on post button")
	public void click_on_post_button() {
		driver.findElement(By.xpath(HomePage.CLICK_POST_BUTTON)).click();
	}


}
