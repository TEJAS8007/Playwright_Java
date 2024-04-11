package PLAYWRIGHTtestng;

import org.testng.annotations.*;
import com.microsoft.playwright.*;

public class Demo {

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
        page.navigate("https://demo.automationtesting.in/Register.html");
    }

          
    @Test(priority = 1)
    public void test01() {
    	//page.locator("id=msdd").click();
    	
        Locator droplist = page.locator("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul /child ::li");
        int total = droplist.count();
        System.out.println(total);
        
        droplist.allInnerTexts().forEach(ele ->System.out.println(ele));
        
        for(int a=0;a<total;a++) {
        	if(droplist.allInnerTexts().get(a).equals("Hindi")) {
        		droplist.nth(a).click();
        		
        	}
        }
    }
    
    @Test(priority = 2)
    public void selectdrop() {
    	Locator dropdown= page.locator("select#Skills");
    	System.out.println(dropdown.count());
    	//dropdown.selectOption("Java");
    	
    	for(int a=0;a<dropdown.count();a++) {
    		if(dropdown.allInnerTexts().get(a).equals("Java")) {
    			dropdown.nth(a).click();
    			System.err.println();
    		}
    	}
    }
    
    @AfterTest
    public void close() {
    	page.close();
    	browser.close();
    }
    
    @AfterTest
    public void tear() {
    	playwright.close();
    }
}
