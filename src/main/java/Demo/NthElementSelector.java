package Demo;

import com.microsoft.playwright.*;


public class NthElementSelector {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.setDefaultTimeout(40000);

        page.navigate("https://www.bigbasket.com/");

        Locator firstEle = page.locator("div.container.footer-links li a >> nth=0");
        String first_ele = firstEle.textContent();
        System.out.println(first_ele);
        firstEle.click();

       /* Locator lastEle = page.locator("div.container.footer-links li a >> nth=-1");
        String last_ele = lastEle.textContent();
        System.out.println(last_ele);*/

    }
}
