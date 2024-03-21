package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.OrgRepoPageObject;

public class OrganizationRepoSteps {
    private WebDriver driver = Hooks.driver;
    OrgRepoPageObject lp = new OrgRepoPageObject(driver);

   /* @Given("Launch the QEP application as {string}")
    public void launchTheQEPApplicationAs(String url) {
        driver.get(url);
    }

    @Given("Click on login in QEP page")
    public void click_on_login_in_qep_page() {

        lp.clickLogin();
    }

    @When("user enter {string} and {string}")
    public void userEnterAnd(String username, String password) {
        lp.validCredential(username,password);
    }

    @And("Click on Log in button")
    public void clickOnLogInButton() {
        lp.loginButton();
    }*/

    @Given("User able click on any one stream")
    public void userAbleClickOnAnyOneStream() throws InterruptedException {
        lp.viewAllBtn("Development", "Process Documentation", "csk");
        Thread.sleep(5000);
    }

    @Then("User able to click on Download")
    public void userAbleToClickOnDownload() {
        lp.Sbuttons("Download");
    }


}