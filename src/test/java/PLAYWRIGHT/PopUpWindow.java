package PLAYWRIGHT;

import java.nio.file.Paths;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PopUpWindow {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	@BeforeTest
	public void setUp() {
		playwright=Playwright.create();
		browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
		context= browser.newContext();
		page= context.newPage();
		
	}

	@Test
	public void popUpTest() {
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
        
        System.out.println("Main Page Title : "+page.title());
        Page popUp= page.waitForPopup(() -> {
        	page.getByText("Open Window").first().click();
        });
        
        popUp.waitForLoadState();
        //System.out.println(popUp.content()); -- Gives Page source
        
        String popUpTitle=popUp.title();
        System.out.println("Pop up Title : "+popUpTitle);
        
        Assert.assertTrue(popUp.title().equals(popUpTitle));
	
        List<String> footerTextList= popUp.locator("div[class='footer-top pt-40 pb-70']").allTextContents();
	    
        for(String text :footerTextList) {
        	System.out.println(text);
        }
        
        List<ElementHandle> linksList =popUp.querySelectorAll("a");
        
        for(ElementHandle handle :linksList) {
        	ElementHandle elementHandle= handle.asElement();
        	System.out.println(elementHandle.textContent());
        	
        }
        popUp.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("SS.png")));
	}
	
	@AfterTest
	public void tearDown() {
		playwright.close();
	}
}
