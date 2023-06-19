package Demo;

import com.microsoft.playwright.*;

public class XpathUnion {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.setDefaultTimeout(40000);

        page.navigate("https://academy.naveenautomationlabs.com/");

        //xpath union
        Locator session = page.locator("//a[text()='Live sessions'] | //a[text()='sessions']");
        System.out.println(session.textContent());
        session.click();

    }
}
