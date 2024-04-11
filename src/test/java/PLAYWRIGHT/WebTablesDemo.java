package PLAYWRIGHT;
import java.util.List;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WebTablesDemo {

	public static void main(String[] args) {

		Playwright playwright=Playwright.create();

		Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context= browser.newContext();

		Page page= context.newPage();

		page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
	
		Locator row=page.locator("table#example tr ");
	
		row.locator(":scope",new Locator.LocatorOptions()
				.setHasText("Ashton cox"))
		.locator(".select-checkbox").click();
		
		row.locator(":scope").allInnerTexts().forEach(ele ->System.out.println(ele));
	
		System.out.println("================---------------=================");
		page.navigate("https://primeng.org/table");
		
	    Locator rows=page.locator("table#pn_id_15-table tr");
	    String text= rows.locator(":scope",new Locator.LocatorOptions().setHasText("James Butt")).textContent();
	    System.out.println(text);
	    
	    List<String> tableslist=rows.locator(":scope").allInnerTexts();
	    
	    for(String ss : tableslist) {
	    	System.out.println(ss);
	    }
	}
}
