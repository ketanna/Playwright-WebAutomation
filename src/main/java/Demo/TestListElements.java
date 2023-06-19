package Demo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.List;

public class TestListElements {

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
            /*page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("test");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("test@gmail.com");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("Test@1234");
            page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn path").click();*/

            page.setDefaultTimeout(60000);
            //page.navigate("https://www.orangehrm.com/en/contact-sales/");
            page.navigate("https://www.orangehrm.com/");
            //Thread.sleep(50000);

            //Single element
            Locator contactSales = page.locator("text=Contact Sales");
            contactSales.first().click();

            //Multiple element

            Locator country = page.locator("select#Form_getForm_Country option");

            System.out.println(country.count());

           /* for (int i = 0; i <= country.count(); i++) {
                System.out.println(country.nth(i).textContent());
            }*/

            System.out.println("*****************************");

            List<String> countryList = country.allTextContents();
            /*for (String e : countryList) {
                System.out.println(e);
            }*/

            System.out.println("*****************************");
            countryList.forEach(ele -> System.out.println(ele));


            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}


