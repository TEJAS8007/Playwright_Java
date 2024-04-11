package Com.Practice;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo {

	
	@Test(priority = 1)
	public void test_01() {
		
	 	Playwright playwright= Playwright.create();
	 	
	 	Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	 	
	 	BrowserContext context= browser.newContext();
	 	
	 	Page page= context.newPage();
	 	
	 	page.navigate("https://google.com");
	 	
	 	page.locator("[name='q']").fill("Automation Testing");
	}
}
