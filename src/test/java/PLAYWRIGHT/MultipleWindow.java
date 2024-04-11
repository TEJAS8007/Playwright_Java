package PLAYWRIGHT;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleWindow {

	public static void main(String[] args) {


		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext con= browser.newContext();
		Page page = con.newPage();

		page.navigate("https://www.bigbasket.com/");

		Locator footer= page.locator("div[class='container'] :nth-child(1)");

		int footTotal= footer.locator("a").count();
		System.out.println(footTotal);

		Locator about= page.locator("div[class='container'] :nth-child(2)");

		int aboutTotal= about.locator("a").count();
		System.out.println(aboutTotal);
		
		page.keyboard().press("Control");
		
		for(int a=0;a<aboutTotal;a++) {
			//about.fill("page.keyboard().press('"+Control+"'),page.keyboard().press('Enter')");
		}
	}

}

