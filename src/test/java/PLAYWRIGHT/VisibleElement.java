package PLAYWRIGHT;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElement {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://www.amazon.com/");

		Locator link=page.locator("a:visible");

		List<String> innertext=link.allInnerTexts();

		for(String ls:innertext) {
			System.out.println(ls);
		}

		for(int a=0;a<innertext.size();a++) {
			String value=innertext.get(a);
			System.out.println(value);
		}

		int countofimage= page.locator("xpath=//img >> visible=true").count();
		System.out.println("No of Images: "+countofimage);


	}
}
