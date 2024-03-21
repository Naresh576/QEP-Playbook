package stepdefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageobject.AdminUserObject;
import pageobject.ProjectAdminObject;

public class ProjectAdminSteps {
    private WebDriver driver = stepdefinition.Hooks.driver;
    ProjectAdminObject lp = new ProjectAdminObject(driver);

    @Given("user able to click on project Admin {string} and {string} and {string} and {string}")
    public void userAbleToClickOnProjectAdminAndAnd(String firstName, String lastName, String email,String Organization) {
        lp.projectAdmin1();
        lp.projectAdmin2(firstName,lastName,email,Organization);
    }
}
