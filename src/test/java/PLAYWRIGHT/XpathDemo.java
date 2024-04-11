package PLAYWRIGHT;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathDemo {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext con= browser.newContext();
		Page page = con.newPage();

		page.navigate("https://amazon.in/");

		Locator searchbox= page.locator("xpath=//input[@id='twotabsearchtextbox']");

		searchbox.fill("Iphone");

		Locator totalLinks= page.locator("//a[contains(text(),'Amazon')]");
		System.out.println(totalLinks.count());

		List<String>linktexts=totalLinks.allInnerTexts();

		for(String el:linktexts) {
			System.out.println(el);
		}

		page.navigate("https://selectorshub.com/xpath-practice-page/");

		page.locator("//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']")
		.click();

		Locator checkboxes = page.locator("//table[@id='resultTable']//input[@type='checkbox']");
		for(int i=0; i<checkboxes.count(); i++) {
			checkboxes.nth(i).click();
		}
	}
}
