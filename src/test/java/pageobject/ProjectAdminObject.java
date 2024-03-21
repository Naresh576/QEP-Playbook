package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.Hooks;

import java.util.List;

public class ProjectAdminObject {
    private WebDriver driver = Hooks.driver;
    public ProjectAdminObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    private String cProject = "//img[@title='Project Admin']";
    private String pAdmin = "//img[@title='Project Admin']";
    private String cUsers = "//span[text()='Customer Users']/parent::a";
    private String addUsers = "//button[text()='Add Users +']";
    @FindBy(xpath = "(//input[@name='first_name'])[1]")
    WebElement firstName;
    @FindBy(xpath = "(//input[@name='last_name'])[1]")
    WebElement lastName;
    @FindBy(xpath = "(//input[@name='email'])[1]")
    WebElement email;
    @FindBy(xpath = "(//input[@name='organisation'])[1]")
    WebElement Organization;
    private String roleID = "(//select[@formcontrolname='role_id'])[1]";
    private String status = "//select[@class='ng-untouched ng-pristine ng-valid'][1]";
    private String submit = "(//button[@class='add-button1'])[1]";

    public void projectAdmin1() {
        WebElement loc = driver.findElement(By.xpath(String.format(cProject)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
    }
    public void projectAdmin2(String ProjectAdminFirstName,String ProjectAdminLastName,String ProjectAdminEmail,String OrganzationProjectAdmin) {
        driver.findElement(By.xpath(String.format(pAdmin))).click();
        driver.findElement(By.xpath(String.format(cUsers))).click();
        driver.findElement(By.xpath(String.format(addUsers))).click();

        firstName.sendKeys(ProjectAdminFirstName);
        lastName.sendKeys(ProjectAdminLastName);
        email.sendKeys(ProjectAdminEmail);
        Organization.sendKeys(OrganzationProjectAdmin);

        WebElement locator4 = driver.findElement(By.xpath(String.format(roleID)));

        Select roleID = new Select(locator4);
        List<WebElement> sDropdownOptions = roleID.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        roleID.selectByIndex(1);
        WebElement locator5 = driver.findElement(By.xpath(String.format(status)));
        Select status = new Select(locator5);
        List<WebElement> statDropdownOptions = status.getOptions();
        for (WebElement option : statDropdownOptions) {
            System.out.println(option.getText());
        }
        status.selectByIndex(1);
        driver.findElement(By.xpath(String.format(submit))).click();


    }

}
