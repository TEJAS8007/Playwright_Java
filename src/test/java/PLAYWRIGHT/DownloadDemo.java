package PLAYWRIGHT;
import java.nio.file.*;
import com.microsoft.playwright.*;

public class DownloadDemo {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");

		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_mac64.zip')");
		});
		
		//download.cancel(); 
		System.out.println(download.failure());
		
		System.out.println(download.url());
		//System.out.println(download.page().title());

		// path of downloded file
		String path = download.path().toString();
		System.out.println(path);
		
		download.saveAs(Paths.get("Tejas_chrome.zip"));
		System.out.println(download.suggestedFilename());//chromedriver_mac64.zip


	}
}
