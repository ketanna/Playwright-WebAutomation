package Demo;

import com.microsoft.playwright.*;

import java.util.List;

public class VisibleElements {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        //Visible elements

        page.navigate("https://www.amazon.com/");
        List<String> LinksText = page.locator("a:visible").allInnerTexts();
        for (int i=0; i<LinksText.size(); i++){
            System.out.println(LinksText.get(i));
        }

        int imagesCount = page.locator("xpath=//img >> visible=true").count();
        System.out.println(imagesCount);

    }

}
