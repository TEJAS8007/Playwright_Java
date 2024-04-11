package PLAYWRIGHT;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectingConatiner {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
 
		Page page= context.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");
		page.locator("select#Form_getForm_Country").click();
		page.locator("select#Form_getForm_Country: has(option[value='India')]").click();

	}
}
