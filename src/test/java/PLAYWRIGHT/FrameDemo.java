package PLAYWRIGHT;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameDemo {

	public static void main(String[] args) {

		Playwright playwright=Playwright.create();
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context= browser.newContext();
		Page page= context.newPage();
		
		page.navigate("https://jqueryui.com/draggable/");
		
	    FrameLocator frame= page.frameLocator("iframe[class=\"demo-frame\"]");
		
	    String text=frame.locator("text=Drag me around").textContent();
	    System.out.println(text);
	    
	    page.navigate("https://demoqa.com/frames");
	    Frame framename= page.frame("frame1");
	    String text1= framename.locator("text=This is a sample page").textContent();
	    System.out.println(text1);
	}
}
