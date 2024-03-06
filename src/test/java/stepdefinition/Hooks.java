package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hooks{

    public static  WebDriver driver;
   // public static String url = "https://demowebshop.tricentis.com/";
    public static String url="https://qep-testing.qualizeal.com/landing-page";
    //public static String url = "https://ui.cogmento.com/";

    //public static String user = "hemant.chauhan@qualizeal.com";
    //public static String pass = "Password@123";
    //invalid username and password
    public static String user="chotu123@yopmail.com";
    public  static String pass="Chotu786@";

    public static String inputName="BU01";
    public static String description="Demo";

    public static String inputName1="fmc";
    public static String inputName2="DammyDes";

    public static String inputName3="CPS";
    public static String inputName4="CPS Des";
    public static String inputName5="Nani";
    public static String inputName6="Varma";
   // public static String inputName7="nani123@yopmail.com";
    public static String inputName7= "axer123@yopmail.com";

    public static String inputName8= "naresh.sunkari@qualizeal.com";
    public static String inputName9= "Chotu576@";

    public static String user2="sunkarinaresh576@gmail.com";
    public static String pass2="Naresh@";
    public static String User3=" ";
    public static String Pass3=" ";
    @SuppressWarnings("deprecation")



    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void launchApplication() {
        driver.get(url);
    }
    public static String getRandomString(String prefix,int length){
        int randomStringLen = length-prefix.length();
        String generatedString = RandomStringUtils.randomAlphanumeric(randomStringLen);
        return prefix.concat(generatedString);
    }

    @After(order = 1)
    public void failedScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            String folder = dateFormat.format(date);
            DateFormat timeFormat = new SimpleDateFormat("hh.mm.ss");
            String timeStamp = timeFormat.format(date);

            File file = new File(System.getProperty("user.dir")+"/src/test/resources/Screenshots/"+ folder);
            if (!file.exists()) {
                file.mkdir();
            }
            String filepath = file+"/"+scenario.getName()+"_"+timeStamp+".png";

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            File dest=new File(filepath);
            FileUtils.copyFile(src, dest);
        }
    }


 //   @After(order = 0)
//    public void closeBrowser() throws InterruptedException {
//        Thread.sleep(1000);
//        driver.quit();
//    }


}

