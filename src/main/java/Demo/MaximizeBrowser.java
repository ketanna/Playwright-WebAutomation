package Demo;

import com.microsoft.playwright.*;

import java.awt.*;

public class MaximizeBrowser {

    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));

        Page page = context.newPage();

        page.navigate("https://www.amazon.com");
    }
}
