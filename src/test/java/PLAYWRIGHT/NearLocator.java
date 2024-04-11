package PLAYWRIGHT;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page;
public class NearLocator {

	static Page page;
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext con= browser.newContext();
		page = con.newPage();
		page.navigate("http://automationpractice.com/index.php");
		page.locator("input:near(:text('Newsletter'))").fill("naveen@gmail.com");
		
		String price = page.locator("span.price.product-price:below(:text('Faded Short Sleeve T-shirts'))")
							.first().innerText().trim();
		
		System.out.println(price);
		
	}

}
