package Com.Practice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PopUpDemo {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;
	
	@BeforeSuite
	public void setup() {
		playwright=Playwright.create();
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    context=browser.newContext();
	    page= context.newPage();
	}
	
	@Test
	public void popupTest() {
		page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Main Page Title : "+page.title());
		Assert.assertTrue(page.title().equals("Practice Page"));
		System.out.println("Main Page Url   : "+page.url());
		Assert.assertTrue(page.url().equals("https://rahulshettyacademy.com/AutomationPractice/"));
		
		Page PopUp = page.waitForPopup(() ->{
			page.click("text=Open Window");
		});
		
		System.out.println("PopUp Page Title : "+PopUp.title());
		Assert.assertTrue(PopUp.title().equals("QAClick Academy - A Testing Academy to Learn, Earn and Shine"));
		System.out.println("PopUp Page Url   : "+PopUp.url());
		Assert.assertTrue(PopUp.url().equals("http://www.qaclickacademy.com/"));
	}
	
	@AfterTest
	public void tearDown() {
		playwright.close();
	}
}
