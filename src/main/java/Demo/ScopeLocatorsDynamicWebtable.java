package Demo;

import com.microsoft.playwright.*;

public class ScopeLocatorsDynamicWebtable {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();

        page.setDefaultTimeout(40000);

        /*page.navigate("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");

        Locator row = page.locator("table#example tr");
        row.locator(":scope", new Locator.LocatorOptions().setHasText("Ashton Cox")).locator(".select-checkbox").click();
        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));*/

       page.navigate("https://primeng.org/");

        Locator row = page.locator("table#pr_id_1-table tr");
        row.locator(":scope", new Locator.LocatorOptions().setHasText("James Butt")).locator(".p-checkbox-box").click();
        row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));







    }


}
