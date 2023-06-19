package Demo;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Auth_AutoLogin {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();

        Page page = context.newPage();
        page.navigate("http://automationpractice.pl/index.php");
        page.click("a:text('Sign in')");
        page.fill("#email", "naikkt07@gmail.com");
        page.fill("#passwd", "kt07@2023");
        page.click("#SubmitLogin");

        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));





    }
}
