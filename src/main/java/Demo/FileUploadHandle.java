package Demo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadHandle {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.setDefaultTimeout(40000);
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        //Upload single file:
        //selector: input type = file
        page.setInputFiles("input#filesToUpload", Paths.get("applogin.json"));
        Thread.sleep(4000);
        page.setInputFiles("input#filesToUpload", new Path[0]);//to remove file uploaded
        Thread.sleep(2000);

        //Upload multiple files:
        page.setInputFiles("input#filesToUpload", new Path[]{Paths.get("C:\\Users\\bbdnet10082\\Downloads\\MicrosoftTeams-image (5).png"),
                Paths.get("applogin.json"), Paths.get("C:\\Users\\bbdnet10082\\Downloads\\loadingScreen.png")});
        page.reload();//to remove file uploaded

        //Run time file - create new file and uploaded at runtime

        page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
        page.setInputFiles("input[name='upfile']", new FilePayload("Ketan.pdf",
                "application/pdf",
                "This is new file".getBytes(StandardCharsets.UTF_8)));
        page.click("input[value='Press']");


    }
}
