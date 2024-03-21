package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.OrgRepoPageObject;
import pageobject.ProjectRepositoryObject;

public class ProjectRepositorySteps {
    private WebDriver driver = Hooks.driver;
    ProjectRepositoryObject lp = new ProjectRepositoryObject(driver);
    @Given("User able to click on project repository")
    public void userAbleToClickOnProjectRepository() {

        lp.projectRepo();
    }

    @When("User able to select any one project")
    public void userAbleToSeeSelectAnyOneProject() throws InterruptedException {
        lp.viewProject("QualiCentral Admin","Software Testing","testplan");
    }

    @Then("User able to click on download button")
    public void verifyUserAbleToClickOnDownloadButton() {

        lp.selectButton("Back");
    }


}
