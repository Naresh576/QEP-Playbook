package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.AdminUserObject;

public class AdminUserSteps {
    private WebDriver driver = stepdefinition.Hooks.driver;
    AdminUserObject lp = new AdminUserObject(driver);

//    @Given("user able to click on org Admin")
//    public void userAbleToClickOnorgAdmin() {
//        lp.admin("Portfolio");
//    }
    @Given("user able to click on organization Admin")
    public void userAbleToClickOnOrganizationAdmin() {
        lp.admin("Portfolio");
    }

    /*@When("usr able to add Bunit")
    public void usrAbleToAddBunit() {
        lp.addBunit();
    }*/
//    @When("user able to Enter {string} Names")
//    public void userAbleToEnterNames(String userInputName) {
//        lp.addBunit(userInputName);
//    }
    @When("user able to Enter {string} and {string} Names")
    public void userAbleToEnterAndNames(String userInputName, String userInputName1) {
        lp.addBunit(userInputName,userInputName1);
    }

//    @And("user able to click on program and Add")
//    public void userableToClickOnProgramAndAdd() {
//        lp.addProgram("Programs","Add Program +","BU01");
//    }
    @And("user able to Enter {string} and {string} name")
    public void userAbleToEnterAndName(String programName, String programdescription) {
        lp.addProgram("Programs","Add Program +",programName,programdescription,"BU01");
    }


    @And("user able to Enter {string} and {string} project name")
    public void userAbleToEnterAndProjectName(String selectProgram, String selectManager) {
        lp.createProject("Add Project +",selectProgram,selectManager,"Automation","Anusri chelamkuri mani");
    }

    @When("user able to give Input values {string} and {string} and {string}")
    public void userAbleToGiveInputValuesAndAnd(String firstName, String lastName, String email) {
        lp.createUser(firstName,lastName,email,"jaddu123@yopmail.com");
    }


    @When("user able to Add project in users")
    public void userAbleToAddProjectInUsers() {
        lp.addProject("ADD ","Select Business Unit","HealthCare","Program Name","Fever","Project Name","Dummy Test Project");
    }

    @Then("verify the {string} mail on Admin page")
    public void verifyTheMailOnAdminPage(String validateEmail) {
        lp.Validation(validateEmail);
    }
}
