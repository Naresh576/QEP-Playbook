package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.Hooks;

import java.util.List;

public class AdminUserObject {
    private WebDriver driver = Hooks.driver;
    public AdminUserObject(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[@title='Admin']")
    WebElement userAdmin;
    private String bussinesUnit = "//span[text()='%s']/parent::a";
    @FindBy(xpath = "//a[text()='Add Portfolio + ']")
    WebElement businessAddUnit ;
    public void admin(String clickBussinessUnit) {
        userAdmin.click();
        WebElement loc1 = driver.findElement(By.xpath(String.format(bussinesUnit, clickBussinessUnit)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);
        businessAddUnit.click();
    }
    @FindBy(xpath = "//label[@class='label-text']/parent::div[@class='form-group']/input")
    WebElement inputName;
    @FindBy(xpath = "//label[@class='label-text']/parent::div[@class='form-group']/textarea")
    WebElement BussinessUnitDescription;
    private static By selectPortfolioStatus = By.xpath("(//select[@formcontrolname='status'])[1]");
    @FindBy(xpath = "//input[@value='Submit']")
    WebElement clickPortfolioSubmit;
    public void addBunit(String userInputName,String userInputName1) {
        inputName.sendKeys(userInputName);
        BussinessUnitDescription.sendKeys(userInputName1);
        WebElement loc2 = driver.findElement(selectPortfolioStatus);
        Select bUnit = new Select(loc2);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(2);
        clickPortfolioSubmit.click();
    }

    private String clickProgramLink = "//span[text()='%s']/parent::a";
    private String AddProgramLink = "//button[text()='%s']";
    @FindBy(xpath = "(//input[@name='program_name'])[1]")
    WebElement enterProgramName;
    @FindBy(xpath = "(//textarea[@name='description'])[1]")
    WebElement enterDescription;
    @FindBy(xpath = "(//span[@class='dropdown-down'])[1]")
    WebElement clickPortfolioUnit;
    private String selectportfolioUnit = "(//div[@class='ng-star-inserted' and text()='%s'])[1]";
    @FindBy(xpath = "(//button[@class='add-button1'])[1]")
    WebElement selectProgramSubmitButton;
    public void addProgram(String program, String AddProgram1,String enterInputProgram,String description, String selectBu) {

        WebElement loc = driver.findElement(By.xpath(String.format(clickProgramLink, program)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);

        WebElement loc1 = driver.findElement(By.xpath(String.format(AddProgramLink, AddProgram1)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);
        enterProgramName.sendKeys(enterInputProgram);
        enterDescription.sendKeys(description);

        WebElement loc4 = driver.findElement(selectPortfolioStatus);
        Select bUnit = new Select(loc4);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(2);
        clickPortfolioUnit.click();
        WebElement loc6 = driver.findElement(By.xpath(String.format(selectportfolioUnit, selectBu)));
        JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
        jsExecutor5.executeScript("arguments[0].click();", loc6);

        selectProgramSubmitButton.click();
    }

    private String clickProjectlink = "//span[text()='Projects']/parent::a";
    private String addProject= "//a[text()='%s']";
    @FindBy(xpath ="(//input[@name='name'])[1]")
    WebElement EnterProjectName;
    @FindBy(xpath ="(//textarea[@name='description'])[1]")
    WebElement EnterDescriptionProjectName;
    @FindBy(xpath ="(//span[@class='dropdown-down'])[1]")
    WebElement clickProgramInput;
    @FindBy(xpath ="(//span[@class='dropdown-down'])[1]")
    WebElement clickManagerInput;
    @FindBy(xpath ="(//span[@class='dropdown-down'])[1]")
    WebElement clickProjectSubmit;
    public void createProject(String projectAdd,String projectInputName,String projectDescription, String selectProgram, String selectManager) {
        WebElement loc = driver.findElement(By.xpath(String.format(clickProjectlink)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);

        WebElement loc1 = driver.findElement(By.xpath(String.format(addProject, projectAdd)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc1);

        EnterProjectName.sendKeys(projectInputName);

        EnterDescriptionProjectName.sendKeys(projectDescription);

        WebElement loc4 = driver.findElement(selectPortfolioStatus);
        Select bUnit = new Select(loc4);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(2);

        clickProgramInput.click();

        WebElement loc6 = driver.findElement(By.xpath(String.format(selectportfolioUnit, selectProgram)));
        JavascriptExecutor jsExecutor6 = (JavascriptExecutor) driver;
        jsExecutor6.executeScript("arguments[0].click();", loc6);

        clickManagerInput.click();

        WebElement loc8 = driver.findElement(By.xpath(String.format(selectportfolioUnit, selectManager)));
        JavascriptExecutor jsExecutor8 = (JavascriptExecutor) driver;
        jsExecutor8.executeScript("arguments[0].click();", loc8);

        clickProjectSubmit.click();
    }
    private String clickUserName = "//span[text()='Users']";
    @FindBy(xpath = "//button[text()='Add User +']")
    WebElement AddUser;
    @FindBy(xpath = "(//input[@name='first_name'])[1]")
    WebElement InputFirstName;
    @FindBy(xpath = "(//input[@name='last_name'])[1]")
    WebElement InputLastName;
    @FindBy(xpath = "(//input[@name='email'])[1]")
    WebElement InputEmail;
    private static By selectRole = By.xpath("(//select[@formcontrolname='role_id'])[1]");
    @FindBy(xpath = "//button[@value='Submit']")
    WebElement UserSubmitButton;
    private String clickView = "(//tr[@class='ng-star-inserted']/td[text()='%s']/following::td[@class='assigned']/a[text()=' View'])[1]";
    public void createUser(String firstName, String lastName, String email,String viewLink) {
        WebElement loc = driver.findElement(By.xpath(String.format( clickUserName)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
        driver.navigate().refresh();
        AddUser.click();
        InputFirstName.sendKeys(firstName);
        InputLastName.sendKeys(lastName);
        InputEmail.sendKeys(email);

        WebElement loc5 = driver.findElement(selectRole);
        Select bUnit = new Select(loc5);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(1);
        UserSubmitButton.click();

        WebElement loc7 = driver.findElement(By.xpath(String.format(clickView, viewLink)));
        JavascriptExecutor jsExecutor6 = (JavascriptExecutor) driver;
        jsExecutor6.executeScript("arguments[0].click();", loc7);

    }
    private String AProj = "//button[text()='%s']";
    private String cModify = "//button[text()='%s']";
    private String selectBu = "//span[normalize-space(text()) ='%s']";
    private String selectBU1 = "//div[text()='%s']";
    private String sSubmit1 = "//input[@value='Submit']";

    public void addProject(String operation2, String sBusiness, String sBusiness1, String adProgram, String selectProgram, String selectProject, String selectProject1) {
        if (operation2 == "ADD ") {
            WebElement loc = driver.findElement(By.xpath(String.format(AProj, "ADD ")));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", loc);

        } else if (operation2 == "MODIFY") {
            WebElement ab1 = driver.findElement(By.xpath(String.format(cModify, "MODIFY")));
            ab1.click();

        }
        WebElement loc1 = driver.findElement(By.xpath(String.format(selectBu, sBusiness)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);

        WebElement loc2 = driver.findElement(By.xpath(String.format(selectBU1, sBusiness1)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc2);

        WebElement loc3 = driver.findElement(By.xpath(String.format(selectBu, adProgram)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc3);

        WebElement loc4 = driver.findElement(By.xpath(String.format(selectBU1, selectProgram)));
        JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
        jsExecutor4.executeScript("arguments[0].click();", loc4);

        WebElement loc5 = driver.findElement(By.xpath(String.format(selectBu, selectProject)));
        JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
        jsExecutor5.executeScript("arguments[0].click();", loc5);

        WebElement loc6 = driver.findElement(By.xpath(String.format(selectBU1, selectProject1)));
        JavascriptExecutor jsExecutor6 = (JavascriptExecutor) driver;
        jsExecutor6.executeScript("arguments[0].click();", loc6);
        WebElement loc7 = driver.findElement(By.xpath(String.format(sSubmit1)));
        JavascriptExecutor jsExecutor7 = (JavascriptExecutor) driver;
        jsExecutor7.executeScript("arguments[0].click();", loc7);
        driver.navigate().refresh();
    }

    private String mail = "//input[@class='col-sm-6 search']";
    public void Validation(String validateEmail) {
        String email = "jaddu123@yopmail.com";
        WebElement loc = driver.findElement(By.xpath(String.format(mail)));
        loc.sendKeys(validateEmail);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
        assertEqualStrings(email, validateEmail);
        System.out.println(" Expected "+email+ " Atual "+validateEmail);

    }

    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
    }
    private static void assertEqualStrings(String expected, String actual) {
        assert expected.equals(actual) : "Strings are not equal: expected '" + expected + "', actual '" + actual + "'";
    }


}
