package PLAYWRIGHT;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
public class Example {
	public static void main(String[] args) {

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
					.setHeadless(false));
			BrowserContext context = browser.newContext();

			// Start tracing before creating / navigating a page.
			context.tracing().start(new Tracing.StartOptions()
					.setScreenshots(true)
					.setSnapshots(true)
					.setSources(true));

			Page page = context.newPage();
			page.navigate("https://www.facebook.com/");
			page.getByTestId("royal_email").click();
			page.getByTestId("royal_email").fill("QQQQ");
			page.getByTestId("royal_pass").click();
			page.getByTestId("royal_pass").fill("qqqq");
			page.getByTestId("royal_login_button").click();



			// Stop tracing and export it into a zip archive.
			context.tracing().stop(new Tracing.StopOptions()
					.setPath(Paths.get("trace.zip")));
		}
	}
}

