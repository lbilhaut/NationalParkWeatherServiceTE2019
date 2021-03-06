package com.techelevator.npgeek.cukes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.*;
import org.junit.runner.RunWith;

import com.techelevator.npgeek.model.Park;

import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)

public class FavoriteParksSelenium {
	private static WebDriver webDriver;
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		

		
		String homeDir = System.getProperty("user.home"); // ~ or $HOME
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver.get("http://localhost:8080/m3-java-capstone/favoriteParks");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}      

	@Test
	/* Whenever possible, it is best to find page elements using the
	 * HTML id attribute since this is the most efficient. Remember
	 * that the element id is supposed to be unique per page */
	public void elements_can_be_found_by_id() {
		WebElement savingsH2 = webDriver.findElement(By.id("resultSurveyGrid"));
	}

	@Test
	public void single_elements_can_be_found_by_tag_name() {
		WebElement header = webDriver.findElement(By.tagName("header"));
		WebElement footer = webDriver.findElement(By.id("footerText"));
		Assert.assertNotNull(header);
		Assert.assertNotNull(footer);
	}
	
//	
//	@Test
//	public void multiple_elements_can_be_found_by_tag_name() {
//		List<WebElement> sections = webDriver.findElements(By.tagName("section"));
//		Assert.assertEquals(3, sections.size());
//		for(WebElement section : sections) {
//			Assert.assertEquals("account", section.getAttribute("class"));
//		}
//	}
//	
	@Test
	public void pages_can_be_navigated_by_clicking_on_links() {
		// Link elements (i.e. <a> tags) can be found based on their text
		WebElement calculatorLink = webDriver.findElement(By.id("SurveyParkImage")); 
	}
}// <a href="www.whatever.com"> THIS IS THE LINK TEXT</a>
		//calculatorLink.click();