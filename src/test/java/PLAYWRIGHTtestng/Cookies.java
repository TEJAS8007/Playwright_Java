package PLAYWRIGHTtestng;

import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.Cookie;

public class Cookies {


	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	@BeforeSuite
	public void setup() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		context = browser.newContext();
		page = context.newPage();
	}

	@BeforeTest
	public void geturl() {
		page.navigate("https://www.flipkart.com/");
	}

	@Test
	public void testcookies() {
		List<Cookie> allcoockies= context.cookies();

		for(Cookie cok :allcoockies) {
			System.out.println(cok.name);
			System.out.println(cok.domain);
			System.out.println(cok.path);
			System.out.println(cok.url);
			System.out.println(cok.value);
			System.out.println(cok.expires);
			System.out.println(cok.httpOnly);
			System.out.println(cok.secure);

			System.out.println("======================================================");
		}

		System.out.println("Adding one Coockie");
 
		
	}
	
	@Test(priority = 2)
	public void testa() {
		System.out.println("Tejas Aware");
	}
}
