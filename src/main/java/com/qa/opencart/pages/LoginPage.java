package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    //1. String locators--> Object Repository

    private String emailID = "#input-email";
    private String password = "//input[@id='input-password']";
    private String loginBtn = "//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    //2. page constructor:
    public LoginPage(Page page) {
        this.page = page;
    }

    //3. Page actions/methods:
    public String getLoginPageTitle(){
        return page.title();
    }

    public boolean isForgotPwdLinkExist(){
        return page.isVisible(forgotPwdLink);
    }

    public boolean doLogin(String appUsername, String appPassword){
        System.out.println("App creds: " + appUsername + " : "+ appPassword);
        page.fill(emailID, appUsername);
        page.fill(password, appPassword);
        page.click(loginBtn);
        if(page.isVisible(logoutLink)){
            System.out.println("user is logged in successfully...!");
            return true;
        }
        return false;
    }

}
