package com.gmail;

import com.generic.WaitLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeEmail {
    public WebDriver driver;
    public WaitLib wait = new WaitLib();

    public ComposeEmail(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//textarea[@class='vO']")
    private WebElement emailTextBx;

    @FindBy(name="subjectbox")
    private WebElement subjectBoxTextBx;

    @FindBy(xpath="//div[@class='Ar Au']//div")
    private WebElement messageBodyTextBx;

    @FindBy(xpath="//*[@class='z0']//div[@class='T-I T-I-KE L3']")
    private WebElement composeBtn;

    @FindBy(xpath="//div[@class='dC']/div")
    private WebElement sendBtn;


    //setter functions
    public void setemailTextField(String email)
    {
        emailTextBx.sendKeys((email));
    }
    public void setsubjectBoxTextField(String subject)
    {
        subjectBoxTextBx.sendKeys((subject));
    }
    public void setmessageBodyTextBx(String body)
    {
        messageBodyTextBx.sendKeys((body));
    }

    //Click Functions
    public void clickComposeBtn()
    {
        composeBtn.click();
    }

    public void clickSendBtn()
    {
        sendBtn.click();
    }

    public void sendEmail(String rEmail,String sbj, String body)
    {
        this.clickComposeBtn();
        this.setemailTextField(rEmail);
        this.setsubjectBoxTextField(sbj);
        this.setmessageBodyTextBx(body);
        this.clickSendBtn();

    }

}
