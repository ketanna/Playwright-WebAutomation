package Demo;

import com.microsoft.playwright.*;

import java.util.List;

public class CommaSelectors {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.setDefaultTimeout(40000);

        page.navigate("https://academy.naveenautomationlabs.com/");
        Locator ele = page.locator("a:has-text('Courses'),"+ "a:has-text('Demo Site')");

        System.out.println(ele.count());
    }
}
