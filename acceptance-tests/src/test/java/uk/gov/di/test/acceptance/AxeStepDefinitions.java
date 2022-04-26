package uk.gov.di.test.acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.json.JSONObject;
import org.json.JSONArray;
import com.deque.axe.AXE;

import java.net.URL;

import static uk.gov.di.test.acceptance.SignInStepDefinitions.driver;

public class AxeStepDefinitions {

    private static final URL scriptUrl = AxeStepDefinitions.class.getResource("/axe.min.js");

    @Given("a user navigates to the build account page")
    public void a_user_navigates_to_the_build_account_page() {
        driver.get("https://build.account.gov.uk");
    }

    @When("a user runs accessibility tests")
    public void a_user_runs_accessibility_tests() {
        System.out.println("Page in test = " + driver.getTitle());
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl)
                .options("{ runOnly: { type: 'tag', values: ['wcag2a','wcag2aa'] } }")
                .setTimeout(60000).analyze();
        //JSONArray violations = JSONObject.getJSONArray("violations");
        System.out.println(responseJSON.toString(4));
    }

    @Then("the user gets results")
    public void the_user_gets_results() {
        driver.quit();
    }
}
