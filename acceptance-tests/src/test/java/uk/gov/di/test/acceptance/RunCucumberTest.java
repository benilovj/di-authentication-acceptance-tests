package uk.gov.di.test.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html"},
        features = "src/test/resources/uk.gov.di.test.acceptance",
        glue = "uk/gov/di/test/acceptance",
        dryRun = true,
        tags = "@Axe"
)
public class RunCucumberTest {}
