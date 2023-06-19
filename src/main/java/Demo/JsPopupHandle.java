package Demo;

import com.microsoft.playwright.*;

public class JsPopupHandle {

    static String text;

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        //BrowserContext context = browser.newContext();
        Page page = browser.newPage();

        //Listener
        page.onceDialog(dailog -> {
            String text = dailog.message();
            System.out.println(text);
            dailog.accept("Alert from herokuapp");
            //dailog.dismiss();
        });


        //JS Alerts, Prompts, Confirm pop ups:

        page.navigate("http://the-internet.herokuapp.com/javascript_alerts");

        page.click("//button[text()='Click for JS Alert']");
        text= page.textContent("p#result");
        System.out.println(text);
        Thread.sleep(2000);

        page.click("//button[text()='Click for JS Confirm']");
        text= page.textContent("p#result");
        System.out.println(text);
        Thread.sleep(2000);

        page.click("//button[text()='Click for JS Prompt']");
        text= page.textContent("p#result");
        System.out.println(text);
        Thread.sleep(2000);

        page.close();
        browser.close();
        playwright.close();


    }
}
