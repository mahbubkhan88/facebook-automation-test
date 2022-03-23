package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import drivers.Drivers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import xPaths.LandingPage;
import xPaths.LoginPageXPaths;

public class Links {
	
	WebDriver driver = null;
	
	@Before public void openChrome() {
		System.setProperty(Drivers.driverName, Drivers.driverLocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After public void closeChrome() {
		driver.quit();
	}
	
	@Given("Open facebook")
	public void open_facebook() {
		driver.navigate().to("https://www.facebook.com/");
	}

	@And("Click signup link")
	public void click_signup_link() {
		driver.findElement(By.xpath(LandingPage.SIGNUP_LINK)).click();
	}

	@Then("Verify signup page")
	public void verify_signup_page() {
	    System.out.println("Link works perfectly");
	}
	
	@Given("Click messanger link")
	public void click_messanger_link() {
		driver.findElement(By.xpath(LandingPage.MESSANGER_LINK)).click();
	}

	@Then("Verify messanger page")
	public void verify_messanger_page() {
	    
	}
	
}
