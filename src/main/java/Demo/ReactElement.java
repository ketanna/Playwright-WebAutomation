package Demo;

import com.microsoft.playwright.*;

import java.util.List;

public class ReactElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.setDefaultTimeout(40000);

        page.navigate("https://www.netflix.com/in/");
        page.locator("_react=[name='email'] >> input").nth(1).fill("test@test.com");

        page.locator("_react=[data-uia='language-picker-header']").first().click();

        Locator footers = page.locator("_react=[data-uia='footer-link']");

        List<String> footerList = footers.allInnerTexts();

        footerList.forEach(f -> System.out.println(f));

    }
}
