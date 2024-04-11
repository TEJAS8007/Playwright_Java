package PlaywrightSession;

import com.microsoft.playwright.*;


public class Demo {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		/*
		LaunchOptions la=new LaunchOptions();
		la.setChannel("chrome");
		la.setHeadless(false);
		*/
		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		Page page= browser.newPage();
		
		page.navigate("https://www.amazon.com/");
		
		String title= page.title();
		System.out.println(title);
		
		String url= page.url();
		System.out.println(url);
		
		browser.close();
		playwright.close();
		
		
	}
}
