package PLAYWRIGHT;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class RedBus {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    
		BrowserContext context= browser.newContext();
		
		Page page= context.newPage();
		
		page.navigate("https://www.redbus.in/");
		
		Locator from= page.locator("input#src");
		from.fill("pu");
		
		Locator text=page.locator("ul[class='sc-dnqmqq eFEVtU'] text");
	    text.last().waitFor();
	    int textcount=text.count();
	    System.out.println(textcount);
	    
	    text.allInnerTexts().forEach(ele -> System.out.println(ele));
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    for(int a=0;a<textcount;a++) {
	    	if(text.allTextContents().get(a).equals("Nigdi")) {
	    		text.nth(a).click();
	    		break;
	    	}
	    }
	    
	    System.out.println(3);
	}
}
