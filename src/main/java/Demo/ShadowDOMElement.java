package Demo;

import com.microsoft.playwright.*;

public class ShadowDOMElement {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        //Page - DOM - Shadow DOM - Element

        page.navigate("https://books-pwakit.appspot.com/");
        page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing books");

        String booksTitle = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
        System.out.println(booksTitle);



        page.setDefaultTimeout(40000);
        //Page - DOM - iFrame - Shadow DOM - Element
        page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
        page.frameLocator("#pact").locator("div#snacktime input#tea").fill("Ginger tea");

    }

}
