package com.gmail;

import com.generic.WaitLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    public WebDriver driver;
    public WaitLib wait = new WaitLib();

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id=("identifierId"))
    private WebElement emailTextBx;

    @FindBy(name="password")
    private WebElement pwdTextBx;

    @FindBy(id="identifierNext")
    private WebElement nxtBtn;

    @FindBy(id="passwordNext")
    private WebElement pwdNextBtn;

    //setter functions
    public void setemailTextBx(String email)
    {
        emailTextBx.sendKeys((email));
    }
    public void setPwdTextBx(String pwd)
    {
        pwdTextBx.sendKeys((pwd));
    }

     //click functions
    public void clickNextBtn()
    {
        nxtBtn.click();
    }
    public void clickPwdNextBtn()
    {
        pwdNextBtn.click();
    }

    public void loginToGmail(String email, String pwd)
    {
        this.setemailTextBx(email);
        this.clickNextBtn();
        this.setPwdTextBx(pwd);
        this.clickPwdNextBtn();

    }
}
