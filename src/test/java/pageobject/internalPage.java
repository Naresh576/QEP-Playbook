package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.Hooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class internalPage {
    private WebDriver driver = Hooks.driver;

    public internalPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    private By login = By.xpath("(//button[text()='Login'])");
    private By userName = By.xpath("//input[@formcontrolname='email']");
    private By password = By.xpath("//input[@formcontrolname='password']");
    private By loginBtn = By.xpath("//button[@class='button']/div[text()='Log in']");


    public void clickLogin() {

        driver.findElement(login).click();
        driver.navigate().refresh();
    }

    public void userNameField() {

        driver.findElement(userName).sendKeys(Hooks.user);
    }

    public void passwordField() {

        driver.findElement(password).sendKeys(Hooks.pass);
    }

    public void btnLogin() {

        driver.findElement(loginBtn).click();
    }


    //private By documentName = By.xpath("//h1[text()='%s']");
    private String viewAll = "//h1[text()='%s']/..//../button[text()='View All']";
    private String viewAll1 = "//span[text()='%s']/parent::div/following-sibling::div/button[text()='View All']";
    private String previewBtn = "//h5[text()='%s']/parent::div/parent::div/following-sibling::div/button[text()='Preview']";

    //private String PreviewBtn="(//h1[text()='%s']/ancestor::div[@class='card-body']/following-sibling::div/button)[1]";
    // private By preview = By.xpath("");
    public void viewAllBtn(String sSelect, String sSelect1, String preview) throws InterruptedException {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,800)");
        //driver.navigate().refresh();
        scroll();
        Thread.sleep(3000);
//        By loc = By.xpath(String.format(viewAll, sSelect));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loc)).click();
        WebElement loc = driver.findElement(By.xpath(String.format(viewAll, sSelect)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
        //Thread.sleep(3000);
//        scroll();
//        Thread.sleep(5000);
        //driver.findElement(By.xpath(String.format(viewAll1, sSelect1))).click();
        WebElement loc2 = driver.findElement(By.xpath(String.format(viewAll1, sSelect1)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc2);
        // JavascriptExecutor js1 = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,800)");
        scroll();
        Thread.sleep(5000);

        WebElement loc3 = driver.findElement(By.xpath(String.format(previewBtn, preview)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc3);
    }

    private String kBabMenu = "//img[@class='guest-user-kebab1 mt-1']";
    private String sButton = "//a[text()='Share']";
    private String eMail = "//input[@name='email']";
    private String doneBtn = "(//button[text()='Done'])[1]";
    private String mailInput = "//input[@name='loginfmt']";
    private String next = "//input[@id='idSIButton9']";
    private String passWord = "//input[@name='passwd']";

    private String signIN = "//input[@type='submit']";

    //input[@id='idSIButton9']
    public void sMenu() {
        WebElement loc = driver.findElement(By.xpath(String.format(kBabMenu)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);

        WebElement loc1 = driver.findElement(By.xpath(String.format(sButton)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);
        WebElement loc2 = driver.findElement(By.xpath(String.format(eMail)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc2);
        loc2.sendKeys(Hooks.inputName8);

        WebElement loc3 = driver.findElement(By.xpath(String.format(doneBtn)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc3);

        windowHandles();

        WebElement loc4 = driver.findElement(By.xpath(String.format(mailInput)));
        JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
        jsExecutor4.executeScript("arguments[0].click();", loc4);
        loc4.sendKeys(Hooks.inputName8);

        WebElement loc5 = driver.findElement(By.xpath(String.format(next)));
        JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
        jsExecutor5.executeScript("arguments[0].click();", loc5);

        WebElement loc6 = driver.findElement(By.xpath(String.format(passWord)));
        JavascriptExecutor jsExecutor6 = (JavascriptExecutor) driver;
        jsExecutor6.executeScript("arguments[0].click();", loc6);
        loc6.sendKeys(Hooks.inputName9);

        WebElement loc7 = driver.findElement(By.xpath(String.format(signIN)));
        JavascriptExecutor jsExecutor7 = (JavascriptExecutor) driver;
        jsExecutor7.executeScript("arguments[0].click();", loc7);

    }

    public void windowHandles() {
        String firstWindowHandle = driver.getWindowHandle();

        // Open a new tab or window
        ((JavascriptExecutor) driver).executeScript("window.open();");

        // Switch to the new tab or window
        Set<String> windowHandles = driver.getWindowHandles();
        String secondWindowHandle = "";
        for (String handle : windowHandles) {
            if (!handle.equals(firstWindowHandle)) {
                secondWindowHandle = handle;
                break;
            }
        }
        driver.switchTo().window(secondWindowHandle);

        // Open the second URL
        driver.get("https://outlook.office.com/");


    }


    public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
    }

    private void clickButton(String buttonId) {

        // Code to click the button based on the ID
        // This is just a placeholder; replace it with your actual code
    }

    private String download = "//button[text()='%s']";
    private String backBtn = "//button[text()='%s']";

    //    public void templateOptions(String option)
//        {
//            WebElement var = driver.findElement(By.xpath(String.format(download,option)));
//                    var.click();
//        }
//    public void dwnld(String operation) {
//        if (operation == "Download") {
//            WebElement ab = driver.findElement(By.xpath(String.format(download, "Download")));
//            ab.click();
//        } else if (operation == "Back") {
//            WebElement ab1 = driver.findElement(By.xpath(String.format(backBtn, "Back")));
//            ab1.click();
//
//        }
//    }
//
//   // private String repository = "//div[@class='second-sidebar ng-star-inserted']/a/img[@title='Repository']";
    private String repository = "//img[@title='Project-Repository']";

    public void repoBtn() {
//        By repo = By.xpath(String.format(repository));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(repo)).click();
        WebElement loc = driver.findElement(By.xpath(String.format(repository)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
    }

    private String viewPjct = "//span[text()='%s']/parent::div/parent::div/following-sibling::div/button[text()='View Project']";
    private String btnViewAll = "//h1[text()='%s']/parent::div/following-sibling::button[text()='View All']";
    private String btnPreview = "//h1[text()='%s']/parent::div/parent::div/following-sibling::div/button[text()='Preview']";

    public void viewProject(String project, String btnView, String btnPreview1) throws InterruptedException {
        scroll();
        //Thread.sleep(5000);

        WebElement loc4 = driver.findElement(By.xpath(String.format(viewPjct, project)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc4);

        scroll();
        //driver.findElement(By.xpath(String.format(btnViewAll, btnView))).click();
        WebElement loc0 = driver.findElement(By.xpath(String.format(btnViewAll, btnView)));
        JavascriptExecutor jsExecutor0 = (JavascriptExecutor) driver;
        jsExecutor0.executeScript("arguments[0].click();", loc0);

        scroll();
        //Thread.sleep(5000);

        WebElement loc5 = driver.findElement(By.xpath(String.format(btnPreview, btnPreview1)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc5);

    }

    public void dwnld1(String operation1) {
        if (operation1 == "Download") {
            // WebElement ab = driver.findElement(By.xpath(String.format(download, "Download")));
            //ab.click();
            WebElement loc5 = driver.findElement(By.xpath(String.format(download, "Download")));
            JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
            jsExecutor3.executeScript("arguments[0].click();", loc5);


        } else if (operation1 == "Back") {
            WebElement ab1 = driver.findElement(By.xpath(String.format(backBtn, "Back")));
            ab1.click();

        }
    }

    private String uAdmin = "//img[@title='Admin']";
    private String bUnit = "//span[text()='%s']/parent::a";
    private String bAddUnit = "//a[text()='Add Business Unit + ']";
    //private By iName=By.xpath("//label[text()='Business Unit']/../../../div/div/input[@class='form-control ng-pristine ng-invalid ng-touched']");

    public void admin(String bussinessUnit) {
        WebElement loc = driver.findElement(By.xpath(String.format(uAdmin)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);

        WebElement loc1 = driver.findElement(By.xpath(String.format(bUnit, bussinessUnit)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);

        driver.findElement(By.xpath(String.format(bAddUnit))).click();
        //Thread.sleep(5000);

        //driver.findElement(iName).sendKeys(Hooks.inputName);


        // driver.findElement(By.xpath(String.format(iName))).sendKeys(Hooks.inputName);
    }

    private String iName = "//label[@class='label-text']/parent::div[@class='form-group']/input";
    private String Des = "//label[@class='label-text']/parent::div[@class='form-group']/textarea";
    private static By sInput = By.xpath("(//select[@formcontrolname='status'])[1]");
    private String sSubmit = "//input[@value='Submit']";

    public void addBunit() {
        WebElement loc = driver.findElement(By.xpath(String.format(iName)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
        loc.sendKeys(Hooks.inputName);

        WebElement loc1 = driver.findElement(By.xpath(String.format(Des)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);
        loc1.sendKeys(Hooks.description);

        WebElement loc2 = driver.findElement(sInput);
        Select bUnit = new Select(loc2);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(2);

        WebElement loc3 = driver.findElement(By.xpath(String.format(sSubmit)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc3);
    }

    private String aProgram = "//span[text()='%s']/parent::a";
    private String addProgram = "//button[text()='%s']";
    private String iProgram = "(//input[@name='program_name'])[1]";
    private String aDes = "(//textarea[@name='description'])[1]";
    private String sBu = "(//span[@class='dropdown-down'])[1]";
    private String buSelect = "(//div[@class='ng-star-inserted' and text()='%s'])[1]";

    private String sSelect = "(//button[@class='add-button1'])[1]";

    public void admin1(String program, String AddProgram1, String selectBu) {
        WebElement loc = driver.findElement(By.xpath(String.format(aProgram, program)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);

        WebElement loc1 = driver.findElement(By.xpath(String.format(addProgram, AddProgram1)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);

        // driver.findElement(By.xpath(String.format(iProgram))).sendKeys(Hooks.inputName1);
        WebElement loc2 = driver.findElement(By.xpath(String.format(iProgram)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc2);
        loc2.sendKeys(Hooks.inputName1);
        WebElement loc3 = driver.findElement(By.xpath(String.format(aDes)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc3);
        loc3.sendKeys(Hooks.inputName2);

        WebElement loc4 = driver.findElement(sInput);
        Select bUnit = new Select(loc4);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(2);


        WebElement loc5 = driver.findElement(By.xpath(String.format(sBu)));
        JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
        jsExecutor4.executeScript("arguments[0].click();", loc5);

        WebElement loc6 = driver.findElement(By.xpath(String.format(buSelect, selectBu)));
        JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
        jsExecutor5.executeScript("arguments[0].click();", loc6);

        WebElement loc7 = driver.findElement(By.xpath(String.format(sSelect)));
        JavascriptExecutor jsExecutor6 = (JavascriptExecutor) driver;
        jsExecutor6.executeScript("arguments[0].click();", loc7);
    }

    private String pProject = "//span[text()='Projects']/parent::a";
    private String aProject = "//a[text()='%s']";
    private String iProject = "(//input[@name='name'])[1]";
    private String pDes = "(//textarea[@name='description'])[1]";
    private String pManager = "(//span[text()='Select Project Manager'])[1]";

    private String submitBtn = "//input[@value='Submit']";

    public void cProject(String projectAdd, String sProgram, String selectBU) {
        WebElement loc = driver.findElement(By.xpath(String.format(pProject)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);

        WebElement loc1 = driver.findElement(By.xpath(String.format(aProject, projectAdd)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc1);

        WebElement loc2 = driver.findElement(By.xpath(String.format(iProject)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc2);
        loc2.sendKeys(Hooks.inputName3);

        WebElement loc3 = driver.findElement(By.xpath(String.format(pDes)));
        JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
        jsExecutor4.executeScript("arguments[0].click();", loc3);
        loc3.sendKeys(Hooks.inputName4);

        WebElement loc4 = driver.findElement(sInput);
        Select bUnit = new Select(loc4);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(2);

        WebElement loc5 = driver.findElement(By.xpath(String.format(sBu)));
        JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
        jsExecutor5.executeScript("arguments[0].click();", loc5);

        WebElement loc6 = driver.findElement(By.xpath(String.format(buSelect, sProgram)));
        JavascriptExecutor jsExecutor6 = (JavascriptExecutor) driver;
        jsExecutor6.executeScript("arguments[0].click();", loc6);

        WebElement loc7 = driver.findElement(By.xpath(String.format(pManager)));
        JavascriptExecutor jsExecutor7 = (JavascriptExecutor) driver;
        jsExecutor7.executeScript("arguments[0].click();", loc7);

        WebElement loc8 = driver.findElement(By.xpath(String.format(buSelect, selectBU)));
        JavascriptExecutor jsExecutor8 = (JavascriptExecutor) driver;
        jsExecutor8.executeScript("arguments[0].click();", loc8);

        WebElement loc9 = driver.findElement(By.xpath(String.format(submitBtn)));
        JavascriptExecutor jsExecutor9 = (JavascriptExecutor) driver;
        jsExecutor9.executeScript("arguments[0].click();", loc9);
    }

    private String cUser = "//span[text()='Users']";
    private String aUser = "//button[text()='Add User +']";
    //private String inputField="//label/ancestor::div[@class='row']//input[@formcontrolname='%s' and contains(@class,'form-control ng-pristine')]";
    // private String inputField="//label/ancestor::form[@class='ng-pristine ng-invalid ng-touched']//input[@name='%s']";
    private String inp = "(//input[@name='%s'])[1]";
    private String inp1 = "(//input[@name='%s'])[1]";
    private String inp2 = "(//input[@name='%s'])[1]";
    private static By sRole = By.xpath("(//select[@formcontrolname='role_id'])[1]");
    private String submitBtn2 = "//button[@value='Submit']";

    private String cView = "(//tr[@class='ng-star-inserted']/td[text()='%s']/following::td[@class='assigned']/a[text()=' View'])[1]";

    public void users(String ifirst, String iLast, String email, String viewB) {
        WebElement loc = driver.findElement(By.xpath(String.format(cUser)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
        driver.navigate().refresh();
        WebElement loc1 = driver.findElement(By.xpath(String.format(aUser)));
        JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
        jsExecutor1.executeScript("arguments[0].click();", loc1);

        WebElement loc2 = driver.findElement(By.xpath(String.format(inp, ifirst)));
        JavascriptExecutor jsExecutor2 = (JavascriptExecutor) driver;
        jsExecutor2.executeScript("arguments[0].click();", loc2);
        loc2.sendKeys(Hooks.inputName5);
        WebElement loc3 = driver.findElement(By.xpath(String.format(inp1, iLast)));
        JavascriptExecutor jsExecutor3 = (JavascriptExecutor) driver;
        jsExecutor3.executeScript("arguments[0].click();", loc3);
        loc3.sendKeys(Hooks.inputName6);
        WebElement loc4 = driver.findElement(By.xpath(String.format(inp2, email)));
        JavascriptExecutor jsExecutor4 = (JavascriptExecutor) driver;
        jsExecutor4.executeScript("arguments[0].click();", loc4);
        loc4.sendKeys(Hooks.inputName7);

        WebElement loc5 = driver.findElement(sRole);
        Select bUnit = new Select(loc5);
        List<WebElement> sDropdownOptions = bUnit.getOptions();
        for (WebElement option : sDropdownOptions) {
            System.out.println(option.getText());
        }
        bUnit.selectByIndex(1);

        WebElement loc6 = driver.findElement(By.xpath(String.format(submitBtn2)));
        JavascriptExecutor jsExecutor5 = (JavascriptExecutor) driver;
        jsExecutor5.executeScript("arguments[0].click();", loc6);

        WebElement loc7 = driver.findElement(By.xpath(String.format(cView, viewB)));
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

            // WebElement abc = driver.findElement(By.xpath(String.format(AProj, "ADD ")));
            // abc.click();
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

    public void Validation(String vmail) {
        String email = "axer123@yopmail.com";
        WebElement loc = driver.findElement(By.xpath(String.format(mail)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);
        loc.sendKeys(Hooks.inputName7);
        assertEqualStrings(email, vmail);


        //String loc=driver.findElement(By.xpath(mail)).getText();
        //System.out.println(loc);
        //Assert.assertEquals(vmail,loc);
    }

    private static void assertEqualStrings(String expected, String actual) {
        assert expected.equals(actual) : "Strings are not equal: expected '" + expected + "', actual '" + actual + "'";
    }

    private String cProject = "//img[@title='Project Admin']";

    public void projectAdmin1() {
        //driver.navigate().refresh();
        WebElement loc = driver.findElement(By.xpath(String.format(cProject)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loc);


    }

    private String pAdmin = "//img[@title='Project Admin']";
    //private String Teammembers="//span[text()='Team Members']";
    private String cUsers = "//span[text()='Customer Users']/parent::a";
    private String addUsers = "//button[text()='Add Users +']";
    private String firstName = "(//input[@name='first_name'])[1]";
    private String lastName = "(//input[@name='last_name'])[1]";
    private String email = "(//input[@name='email'])[1]";
    private String orgA = " (//input[@name='organisation'])[1]";
    private String roleID = "(//select[@formcontrolname='role_id'])[1]";
    // private  String customerRole= ("//select[@class='ng-touched ng-dirty ng-valid']");
    private String status = "//select[@class='ng-untouched ng-pristine ng-valid'][1]";
    private String submit = "(//button[@class='add-button1'])[1]";

    public void projectAdmin2() {
        driver.findElement(By.xpath(String.format(pAdmin))).click();
        driver.findElement(By.xpath(String.format(cUsers))).click();
        driver.findElement(By.xpath(String.format(addUsers))).click();
        WebElement locator = driver.findElement(By.xpath(String.format(firstName)));
        locator.sendKeys(Hooks.inputNameNew);
        WebElement locator1 = driver.findElement(By.xpath(String.format(lastName)));
        locator1.sendKeys(Hooks.inputLastName);
        WebElement locator2 = driver.findElement(By.xpath(String.format(email)));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", locator2);
        locator2.sendKeys(Hooks.emailId);
        //locator2.sendKeys(Data.emailId);
        WebElement locator3 = driver.findElement(By.xpath(String.format(orgA)));
        locator3.sendKeys(Hooks.org);
        WebElement locator4 = driver.findElement(By.xpath(String.format(roleID)));
        //locator4.click();
        //WebElement locator5=driver.findElement((customerRole);
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