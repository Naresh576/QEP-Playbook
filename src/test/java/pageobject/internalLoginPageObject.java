package pageobject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinition.Hooks;

import java.time.Duration;

public class internalLoginPageObject {
    private WebDriver driver = Hooks.driver;
    public internalLoginPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[text()='Login']")
    WebElement login;
    public void clickLogin(){
        login.click();
    }
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailtext;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordtext;
    public void validCredential(String user, String password){
        emailtext.sendKeys(user);
        passwordtext.sendKeys(password);
    }
    @FindBy(xpath = "//button[@class='button']/div[text()='Log in']")
    WebElement loginbutton;
    public void loginButton(){
        loginbutton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @FindBy(xpath = "//h1[text()='Recently Uploaded Documents']")
    WebElement pageText;
    public void validatePageText(String PageTxt){
        String loc = pageText.getText();
        System.out.println(loc);
        Assert.assertEquals(loc, PageTxt);
    }


    @FindBy(xpath = "//div[contains(text(),'Invalid Credentials!!')]")
    WebElement inValidCredentialsErrorMessage;

    public void capturingErrorMessage(){
        inValidCredentialsErrorMessage.getText();
    }
    @FindBy(xpath = "//h5[text()='Email is required']")
    WebElement emailfieldError;
    public void emailFieldErrorMessage(){
        emailfieldError.getText();

    }
    @FindBy(xpath = "//h5[text()='Password is required']")
    WebElement passwordfieldError;

    public void passwordFieldErrorMessage(){
         passwordfieldError.getText();
    }
    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
    }



}

