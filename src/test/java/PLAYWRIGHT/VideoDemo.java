package PLAYWRIGHT;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoDemo {

	public static void main(String[] args) {
		
		Dimension screensize= Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int) screensize.getWidth();
		int height=(int) screensize.getHeight();
		System.out.println(width +" : "+height);
		
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context= browser.
				newContext(
						new Browser.NewContextOptions
						().setRecordVideoDir(Paths.get("Myvideos/")));
		
		Page page = context.newPage();
		page.navigate("https://www.google.com");
		
		page.locator("id=APjFqb").fill("Hii..");
		
	}
	
}
