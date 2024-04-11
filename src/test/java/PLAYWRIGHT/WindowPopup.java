package PLAYWRIGHT;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopup {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context1= browser.newContext();
//		BrowserContext context2= browser.newContext();
//		Page page2 = context2.newPage();
//		page2.navigate("https://www.instagram.com");
		
		Page page1 = context1.newPage();
		
		page1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Page popup= page1.waitForPopup(() -> {
			page1.locator("a[target=\"_blank\"]").first().click();
		});
		
		popup.waitForLoadState();
		System.out.println("title of pop up : "+popup.title());
		System.out.println("url of pop up : "+popup.url());
		
		popup.navigate("https://www.google.com/");
		System.out.println("title of pop up : "+popup.title());
		System.out.println("url of pop up : "+popup.url());
		
	}
}
