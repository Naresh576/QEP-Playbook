package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinition.Hooks;

import java.time.Duration;

public class OrgRepoPageObject {
    private WebDriver driver = Hooks.driver;
    public OrgRepoPageObject(WebDriver driver) {

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
        private String viewAll = "//h1[text()='%s']/..//../button[text()='View All']";

        private String viewAll1 = "//span[text()='%s']/parent::div/following-sibling::div/button[text()='View All']";
        private String previewBtn = "//h5[text()='%s']/parent::div/parent::div/following-sibling::div/button[text()='Preview']";
        private String download = "//button[text()='%s']";
        private String backBtn = "//button[text()='%s']";
        public void viewAllBtn(String streamName, String categoryName, String projectName){

            scroll();
            WebElement loc = driver.findElement(By.xpath(String.format(viewAll,streamName)));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", loc);

            WebElement loc2 = driver.findElement(By.xpath(String.format(viewAll1, categoryName)));
            JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
            jsExecutor2.executeScript("arguments[0].click();", loc2);
            scroll();
            WebElement loc3 = driver.findElement(By.xpath(String.format(previewBtn, projectName)));
            JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
            jsExecutor1.executeScript("arguments[0].click();", loc3);

        }
        public void scroll() {
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0,900)");
    }
    public void Sbuttons(String operation1) {
        if (operation1 == "Download") {
            WebElement loc = driver.findElement(By.xpath(String.format(download, "Download")));
            JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
            jsExecutor1.executeScript("arguments[0].click();", loc);

        } else if (operation1 == "Back") {
            WebElement ab1 = driver.findElement(By.xpath(String.format(backBtn, "Back")));
            ab1.click();

        }
    }


    }


