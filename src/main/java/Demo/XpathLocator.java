package Demo;

import com.microsoft.playwright.*;

import java.util.List;

public class XpathLocator {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        BrowserContext context = browser.newContext();
        /*Page page = context.newPage();

        page.setDefaultTimeout(40000);

        page.navigate("https://www.amazon.com/");

        page.locator("//input[@id='twotabsearchtextbox']").fill("Macbook pro");

        Locator totalAmazonLinks = page.locator("//a[contains(text(), 'Amazon')]");
        System.out.println(totalAmazonLinks.count());

        List<String> textList = totalAmazonLinks.allInnerTexts();
        for(String e : textList){
            System.out.println(e);
        }*/

        Page page1 = context.newPage();

        page1.setDefaultTimeout(40000);

        page1.navigate("https://selectorshub.com/xpath-practice-page/");

        page1.locator("//a[contains(text(), 'Joe.Root')]/parent::td/preceding-sibling::td/input[@type='checkbox']").click();

        String userRole = page1.locator("//a[contains(text(), 'Joe.Root')]/parent::td/following-sibling::td[1]").textContent();

        System.out.println(userRole);

        //Indexing

        Locator checkboxes = page1.locator("//table[@id='resultTable']//input[@type='checkbox']");

        for(int i =0; i<checkboxes.count(); i++){
            checkboxes.nth(i).click();
            Thread.sleep(2000);
        }
        for(int i =0; i<checkboxes.count(); i++){
            checkboxes.nth(i).click();
            Thread.sleep(2000);
        }

        page1.locator("xpath=(//table[@id='resultTable']//input[@type='checkbox'])[1]").click();
        page1.locator("(//table[@id='resultTable']//input[@type='checkbox'])[last()]").click();
        page1.locator("(//table[@id='resultTable']//input[@type='checkbox'])[position()=3]").click();

    }


}
