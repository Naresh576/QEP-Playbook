package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.internalLoginPageObject;

public class internalLoginSteps {
    private WebDriver driver = Hooks.driver;
    internalLoginPageObject lp = new internalLoginPageObject(driver);
    /*@Given("Launch the QEP application as ")
    public void launch_the_qep_application() {
        stepdefinition.Hooks.launchApplication(url2);
    }*/

    @Given("Launch the QEP application as {string}")
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
    }
    @Then("Validate {string} text on the page")
    public void validateTextOnThePage(String pageText) {

        lp.validatePageText(pageText);
    }

    @And("Verify the error message")
    public void verify_the_error_message() {

        lp.capturingErrorMessage();
    }

    @Then("Verify the error message on email input field")
    public void verifyTheErrorMessageOnInputField() {

        lp.emailFieldErrorMessage();
    }

    @And("Verify the error message on password input field")
    public void verifyTheErrorMessageOnPasswordInputField() {
        lp.passwordFieldErrorMessage();
    }



}
