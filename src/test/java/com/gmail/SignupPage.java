package com.gmail;

import com.generic.WaitLib;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class SignupPage {

    public WebDriver driver;
    public WaitLib wait = new WaitLib();

    public SignupPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id=("firstName"))
    private WebElement fNameTextBx;

    @FindBy(id=("lastName"))
    private WebElement lNameTextBx;

    @FindBy(id=("username"))
    private WebElement userNameTextBx;

    @FindBy(name="Passwd")
    private WebElement pwdTextBx;

    @FindBy(name="ConfirmPasswd")
    private WebElement cnPwdTextBx;

    @FindBy(xpath="//div[@id='accountDetailsNext']//button")
    private WebElement nxtBtn;

    @FindBy(id="phoneNumberId")
    private WebElement pNumTextBx;

    @FindBy(className="VfPpkd-RLmnJb")
    private WebElement pNumNextBtn;

    @FindBy(name="recoveryEmail")
    private WebElement recEmailTextBx;

    @FindBy(name="day")
    private WebElement dayTextBx;

    @FindBy(id="month")
    private WebElement monthBx;

    @FindBy(name="year")
    private WebElement yearTextBx;

    @FindBy(id="gender")
    private WebElement genderBx;

    @FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
    private WebElement nextBtnGoogle;

    @FindBy(xpath ="//span[contains(text(),'Skip')]//parent::button")
    public WebElement skipBtn;

    @FindBy(id="termsofserviceNext")
    public WebElement agreeBtn;

    //setter functions
    public void setfNameTextBx(String firstName)
    {
        fNameTextBx.sendKeys((firstName));
    }
    public void setlNameTextBx(String lastName)
    {
        lNameTextBx.sendKeys((lastName));
    }
    public void setUserNameTextBx(String userName)
    {
        userNameTextBx.sendKeys((userName));
    }
    public void setPwdTextBx(String pwd)
    {
        pwdTextBx.sendKeys((pwd));
    }
    public void setConfirmPwdTextBx(String pwd)
    {
        cnPwdTextBx.sendKeys((pwd));
    }
    public void setpNumTextBx(String number)
    {
        pNumTextBx.sendKeys((number));
    }
    public void setRecEmail(String email)
    {
        recEmailTextBx.sendKeys((email));
    }
    public void setDayTextBx(String day)
    {
        dayTextBx.sendKeys((day));
    }
    public void setYearTextBx(String year)
    {
        yearTextBx.sendKeys((year));
    }

    public void setMonth(String mon)
    {
        Select dropdown = new Select(monthBx);
        dropdown.selectByVisibleText(mon);

    }
    public void setGender(String gen )
    {
        Select dropdown = new Select(genderBx);
        dropdown.selectByVisibleText(gen);

    }

    //click functions
    public void clickNextBtn()
    {
        nxtBtn.click();
    }
    public void clickPhnNextBtn()
    {
        pNumNextBtn.click();
    }
    public void clickNextBtnGoogle()
    {
        nextBtnGoogle.click();
    }

    public void clickAgreeBtn()
    {
        agreeBtn.click();
    }

    public void clickSkipBtn()
    {
        skipBtn.click();
    }

    public void signUpToGmail(String fName,String lName,String userName, String pwd,String cnPwd,String pNum,String rEmail,String mon, String day, String yr, String gen) throws InterruptedException {
        try {
            this.setfNameTextBx(fName);
            wait.implicitWait(driver,10);
            this.setlNameTextBx(lName);
            this.setUserNameTextBx(userName);
            this.setPwdTextBx(pwd);
            this.setConfirmPwdTextBx(cnPwd);
            this.clickNextBtn();
            this.setpNumTextBx(pNum);
            wait.explicitWait(driver, 10, By.className("VfPpkd-RLmnJb"));
            this.clickPhnNextBtn();
            wait.sleepThread(30000); //for manually handling phone verification code
            this.setRecEmail(rEmail);
            this.setDayTextBx(day);
            this.setMonth(mon);
            this.setYearTextBx(yr);
            this.setGender(gen);
            this.clickNextBtnGoogle();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            wait.explicitWait(driver, 20,By.xpath("//span[contains(text(),'Skip')]//parent::button"));
            this.clickSkipBtn();
            this.clickAgreeBtn();
        }
        catch(Exception ex)
        {
            Assert.fail("there is some error in SignUp operation",  ex);

        }

    }
}
