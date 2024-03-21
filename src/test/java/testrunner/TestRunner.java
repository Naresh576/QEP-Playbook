package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "Features/.feature",
        features = "src/test/resources/feature",
        glue = "stepdefinition",
        //tags = "@Test9",
        //tags="@Pass1",
        plugin = {"pretty", "html:src/test/resources/Report/CucumberTestReport.html"}
)

public class TestRunner {

}
