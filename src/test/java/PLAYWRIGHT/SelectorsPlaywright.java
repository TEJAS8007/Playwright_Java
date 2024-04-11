package PLAYWRIGHT;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectorsPlaywright {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		
	 	Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
	 	BrowserContext context= browser.newContext();
	
	 	Page page= context.newPage();
	
	    page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
	    Locator select=page.locator("select#dropdown-class-example option");
	    System.out.println(select.count());
	    
	    for(int a=0;a<select.count();a++) {
	    	String text= select.nth(a).textContent();
	    	System.out.println(text);
	    	
	    	if(text.contains("Option1")) {
	    		select.nth(a).click();
	    	}
	    }
	}
}
