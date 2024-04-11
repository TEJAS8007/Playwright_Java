package PLAYWRIGHTtestng;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demos {

	public static void main(String[] args) {
		
		 Playwright playwright = Playwright.create();
	      Browser  browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	     BrowserContext   context = browser.newContext();
	      Page  page = context.newPage();
	      
	      page.navigate("https://demo.guru99.com/test/newtours/register.php");
	      
	      Locator drop= page.locator("select[name=country]");
	      drop.selectOption("INDIA");
	      
	      if(drop.evaluate(drop.textContent()).equals("INDIA")) {
	    	  System.out.println("Selected");
	      }
	      else {
	    	  System.out.println("Not seleced");
	      }
	}
}
