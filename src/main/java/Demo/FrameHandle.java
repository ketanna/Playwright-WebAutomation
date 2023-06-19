package Demo;

import com.microsoft.playwright.*;

public class FrameHandle {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        //Frames:

        page.navigate("http://www.londonfreelance.org/courses/frames/index.html");

        String header = page.frameLocator("frame[name='main']").locator("h2").textContent();

        String h2 = page.frame("main").locator("h2").textContent();
        System.out.println(header);
        System.out.println(h2);


        //Iframes:

        page.navigate("https://www.formsite.com/templates/registration-form-templates/workshop-registration-form/");

        page.locator("img[title='Workshop-Registration-Forms-and-Examples']").click();

        page.frameLocator("//iframe[contains(@id,'frame-one')]")
                .locator("#RESULT_TextField-5").fill("Test demo");


    }
}
