package PLAYWRIGHT;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DatePicker {

	static String Selectdate;
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://jqueryui.com/datepicker/");
		
		FrameLocator frames= page.frameLocator("iframe[class=\"demo-frame\"]");
	   
	    frames.locator("input#datepicker").click();
	    
	    String date="October 2025";
	    
	    Locator month=frames.locator("span[class='ui-datepicker-month']");
	    System.out.println(month.innerText());
	   
	    
	    Locator year=frames.locator("span[class='ui-datepicker-year']");
	    System.out.println(year.innerText());
	   
	    while(true) {
	    	
	    	if(month.textContent().equals("October") && year.textContent().equals("2025")) {
	    		break;
	    	}
	    	else {
	    		frames.locator("span[class='ui-icon ui-icon-circle-triangle-e']").click();
	    	}
	    }
	    
	    Locator rows= frames.locator("td[data-handler=\"selectDay\"]");
	    System.out.println(rows.count());
	
	    for(int a=0;a<rows.count();a++) {
	    	String dates=rows.allInnerTexts().get(a);
	    	
	    	if(dates.equalsIgnoreCase("25")) {
	    		frames.locator("td[data-handler=\"selectDay\"] a[data-date=\"25\"]").click();
	    	}
	    }
	}
}
