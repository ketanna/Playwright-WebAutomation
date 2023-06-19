package Demo;

import com.microsoft.playwright.*;

import java.util.List;

public class RelativeLocators {
    static Page page;

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        page = context.newPage();

        page.setDefaultTimeout(50000);

        page.navigate("https://selectorshub.com/xpath-practice-page/");

        //page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
        //page.locator("td:right-of(:text('Joe.Root'))").first().textContent();

        selectUser("Joe.Root");
        selectUser("John.Smith");

        System.out.println(getUser("Joe.Root"));
        System.out.println(getUser("John.Smith"));

        String aboveUser = page.locator("a:above(:text('Joe.Root'))").first().textContent();
        System.out.println(aboveUser);

        String belowUser = page.locator("a:below(:text('John.Smith'))").first().textContent();
        System.out.println(belowUser);

        Locator nearElements = page.locator("td:near(:text('Joe.Root'), 400)");
        List<String> nearEleText = nearElements.allInnerTexts();

        for(String e : nearEleText){
            System.out.println(e);
        }

    }

    public static void selectUser(String username) {
        page.locator("input[type='checkbox']:left-of(:text('" + username + "'))").first().click();
    }

    public static String getUser(String username) {
        return page.locator("td:right-of(:text('" + username + "'))").first().textContent();
    }

}
