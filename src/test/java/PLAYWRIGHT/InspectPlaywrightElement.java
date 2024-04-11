package PLAYWRIGHT;

import java.util.List;

import com.microsoft.playwright.*;

public class InspectPlaywrightElement {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://www.amazon.com");
		
		List<String> amzonlinks=page.locator("a:has-text('Amazon')").allInnerTexts();

		for(String ele :amzonlinks) {
			System.out.println(ele);
		}
	}
}
