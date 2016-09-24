package com.vencore.ciap.steps;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebSteps {
	
	WebDriver driver;

	@Given("^\"(.*)\" user has a \"(.*)\" browser open\\.$")
	public void user_has_a_browser_open(String user, String browserType) throws Throwable {
		final File file = new File("/Applications/geckodriver");
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
		driver = new FirefoxDriver(); 
		// Resize the browser window
        Dimension windowSize = new Dimension(1050,1015);
        driver.manage().window().setSize(windowSize);
        // Get the current window ID from the selenium window array.
        // The last entry in the selenium window array is the current window ID.
        String lastWindowHandle = driver.getWindowHandle();
        System.out.println("I am in the first step");

	}

	@When("^he navigates to \"(.*)\" website\\.$")
	public void he_navigates_to_website(String appWebsite) throws Throwable {
		 System.out.println("I am in the second step");
	}

	@Then("^he lands on the \"([^\"]*)\" page\\.$")
	public void he_lands_on_the_page(String arg1) throws Throwable {
		 System.out.println("I am in the third step");
	}

}
