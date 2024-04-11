package PLAYWRIGHT;

import java.util.List;


import com.microsoft.playwright.*;

public class LocateElement {

	public static void main(String[] args) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context= browser.newContext();
	    
		Page page= context.newPage();
	
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");

		/*
		Locator login=page.locator("text=Login").first();
		int logincount= login.count();
		System.out.println(logincount);
		login.hover();
		login.click();
		*/
		
		Locator country= page.locator("select#Form_getForm_Country option");
		System.out.println(country.count());
	    
		// 1st way
		for(int i=0;i<country.count();i++) {
		    String textcountry=country.nth(i).textContent();
		    System.out.println(textcountry);
		}
		
		//2nd way
		List<String>listcountry= country.allTextContents();
		for(String e : listcountry) {
			System.out.println(e);
		}
		
		// 3rd way
		listcountry.forEach(ele ->System.out.println(ele));
	}
}
