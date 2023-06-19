package Demo;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NewAuth_AutoLogin {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("applogin.json")));

        Page page = context.newPage();

        page.navigate("http://automationpractice.pl/index.php");





    }
}
