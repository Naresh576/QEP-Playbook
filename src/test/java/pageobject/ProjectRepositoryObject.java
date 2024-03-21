package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepdefinition.Hooks;

public class ProjectRepositoryObject {
    private WebDriver driver = Hooks.driver;
    public ProjectRepositoryObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    private String repository = "//img[@title='Project-Repository']";

    public void projectRepo() {
            WebElement loc = driver.findElement(By.xpath(String.format(repository)));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", loc);
    }

    private String viewProject = "//span[text()='%s']/parent::div/parent::div/following-sibling::div/button[text()='View Project']";
    private String buttonViewAll = "//h1[text()='%s']/parent::div/following-sibling::button[text()='View All']";
    private String buttonPreview = "//h1[text()='%s']/parent::div/parent::div/following-sibling::div/button[text()='Preview']";
    private String download = "//button[text()='%s']";
    private String backBtn = "//button[text()='%s']";
    public void viewProject(String selectProject, String selectStream, String btnPreview) throws InterruptedException {
        scroll();

        WebElement loc4 = driver.findElement(By.xpath(String.format(viewProject, selectProject)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc4);
        scroll();
        WebElement loc0 = driver.findElement(By.xpath(String.format(buttonViewAll, selectStream)));
        JavascriptExecutor jsExecutor0 = (JavascriptExecutor) driver;
        jsExecutor0.executeScript("arguments[0].click();", loc0);
        scroll();
        WebElement loc5 = driver.findElement(By.xpath(String.format(buttonPreview, btnPreview)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc5);

        Thread.sleep(5000);

    }

    public void selectButton(String operation) {
        if (operation == "Download") {
            WebElement loc = driver.findElement(By.xpath(String.format(download, "Download")));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", loc);


        } else  {
            WebElement ab1 = driver.findElement(By.xpath(String.format(backBtn, "Back")));
            ab1.click();

        }
    }
    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
    }
}
