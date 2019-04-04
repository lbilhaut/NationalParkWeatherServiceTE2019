package com.techelevator.npgeek.cukes;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageSelenium extends Hooks{
	
	
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
		webDriver.get("http://localhost:8080/m3-java-capstone/");
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
		WebElement savingsH2 = webDriver.findElement(By.id("homepageGrid"));
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
		WebElement calculatorLink = webDriver.findElement(By.linkText("Home")); 
	}
}// <a href="www.whatever.com"> THIS IS THE LINK TEXT</a>
		//calculatorLink.click();


	
	
	
	
	
	
	
