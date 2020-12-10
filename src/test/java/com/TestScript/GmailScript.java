package com.TestScript;
import com.generic.ExcelLib;
import com.generic.WaitLib;
import com.gmail.ComposeEmail;
import com.gmail.LoginPage;
import com.gmail.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class GmailScript  {

    WebDriver driver;
    public WaitLib wait = new WaitLib();
    ExcelLib eLib = new ExcelLib();
    LoginPage lP;
    SignupPage sP;
    ComposeEmail cE;

    @BeforeClass()
    public void initialSetup()
    {
        System.setProperty("webdriver.chrome.driver","DriverExe/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test(priority = 0)
    public void SignIn() throws Exception {
        lP = new LoginPage(driver);
        String sheetName = "SignIn";
        driver.navigate().to(eLib.readExcelFile(sheetName,1,0));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        lP.loginToGmail(eLib.readExcelFile(sheetName,1,1),eLib.readExcelFile(sheetName,1,2));

    }
    @Test(priority = 2)
    public void SignUp() throws Exception
    {
        sP = new SignupPage(driver);
        String sheetName = "SignUp";
        driver.navigate().to(eLib.readExcelFile(sheetName,1,0));
        String firstName = eLib.readExcelFile(sheetName,1,1);
        String lastName = eLib.readExcelFile(sheetName,1,2);
        String userName = eLib.readExcelFile(sheetName,1,3);
        String password = eLib.readExcelFile(sheetName,1,4);
        String cPassword = eLib.readExcelFile(sheetName,1,5);
        String pNum = eLib.readExcelFile(sheetName,1,6);
        String rEmail = eLib.readExcelFile(sheetName,1,7);
        String month = eLib.readExcelFile(sheetName,1,8);
        String day = eLib.readExcelFile(sheetName,1,9);
        String year = eLib.readExcelFile(sheetName,1,10);
        String gender = eLib.readExcelFile(sheetName,1,11);
        sP.signUpToGmail(firstName,lastName,userName,password,cPassword,pNum,rEmail,month,day,year,gender);
    }

   @Test(priority=1)
    public void sendingEmail() throws Exception {
        cE = new ComposeEmail(driver);
        String sheetName = "EmailContent";
        cE.sendEmail(eLib.readExcelFile(sheetName,1,0),eLib.readExcelFile(sheetName,1,1),eLib.readExcelFile(sheetName,1,2));
        wait.sleepThread(10000);
    }
    @BeforeMethod()
    public void setWaitForPageLoad()
    {
        wait.implicitWait(driver,15);
    }

   @AfterClass()
    public void QuitBrowser()
    {
        //driver.quit();
    }
}

