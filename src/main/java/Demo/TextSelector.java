package Demo;

import com.microsoft.playwright.*;

public class TextSelector {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();


        page.setDefaultTimeout(40000);
        page.navigate("https://www.orangehrm.com/en/contact-sales/");


        //String header = page.locator("h4:has-text('Let us know how we can help you!')").textContent();
        String header = page.locator("div.contact-form-section-title h4:has-text('Let us know how we can help you!')").textContent();
        System.out.println(header);


        page.navigate("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
       // page.locator("form button:has-text('Login')").click();

        //page.locator("div a.btn btn-primary").click();

        page.close();
        context.close();

    }
}
