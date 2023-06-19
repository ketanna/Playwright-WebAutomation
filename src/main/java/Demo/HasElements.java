package Demo;

import com.microsoft.playwright.*;

import java.util.List;

public class HasElements {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.setDefaultTimeout(40000);

       /* page.navigate("https://www.orangehrm.com/en/contact-sales/");
        Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
        loc.allInnerTexts().stream().forEach(e -> System.out.println(e));*/

        page.navigate("https://www.amazon.com/");
        List<String> footerList = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])").allInnerTexts();
        footerList.forEach(e -> System.out.println(e));

    }


}
