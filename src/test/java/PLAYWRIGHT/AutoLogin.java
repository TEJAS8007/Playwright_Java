package PLAYWRIGHT;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoLogin {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();

		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context= browser.newContext();

		Page page= context.newPage();
		
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		page.fill("input[name=\"username\"]", "Admin");
		
		page.fill("input[name=\"password\"]", "admin123");
		
		page.click("button[type=\"submit\"]");
		
		context.storageState
		(new BrowserContext.StorageStateOptions()
				.setPath(Paths.get("appLogin.json")));
	}
}
