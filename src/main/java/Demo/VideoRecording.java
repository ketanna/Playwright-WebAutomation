package Demo;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class VideoRecording {

    public static void main(String[] args) throws InterruptedException {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(width,height));

        Page page = context.newPage();

        page.setDefaultTimeout(50000);

        page.navigate("https://selectorshub.com/xpath-practice-page/");

        page.locator("//a[contains(text(), 'Joe.Root')]/parent::td/preceding-sibling::td/input[@type='checkbox']").click();

        Locator checkboxes = page.locator("//table[@id='resultTable']//input[@type='checkbox']");

        for(int i =0; i<checkboxes.count(); i++){
            checkboxes.nth(i).click();
            Thread.sleep(2000);
        }
        for(int i =0; i<checkboxes.count(); i++){
            checkboxes.nth(i).click();
            Thread.sleep(2000);
        }

        page.close();
        context.close();
        playwright.close();
    }


}
