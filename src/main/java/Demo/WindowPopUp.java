package Demo;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class WindowPopUp {

    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));

        Page page = browser.newPage();

        page.setDefaultTimeout(50000);

        Page popup;


        //1. Open a new tab/window/pop after clicking on link the parent page:
        /*page.navigate("https://www.orangehrm.com/");
        popup = page.waitForPopup(() -> {
            page.click("img[alt='facebook logo']");
        });
        popup.waitForLoadState();
        System.out.println("Pop up window title: "+ popup.title());
        popup.close();
        System.out.println("Parent window title: "+ page.title());
        //page.close();*/

        //2.Open a new tab/window popup and enter the URL:
        page.navigate("https://google.com");
        popup = page.waitForPopup(()-> {
           page.click("a[target='_blank']");//open a new blank tab window
        });
        popup.waitForLoadState();
        popup.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
        System.out.println("Pop up window title: "+ popup.title());
        popup = page.waitForPopup(()-> {
            page.click("a[class='twitter']");
        });
        popup.waitForLoadState();
        System.out.println("Pop up window title: "+ popup.title());
        page.goBack();
        System.out.println("Parent window title: "+ page.title());

        page.close();



    }


}
