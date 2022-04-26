package uk.gov.di.test.acceptance;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.gov.di.test.acceptance.AccountJourneyPages.ACCOUNT_DELETED_CONFIRMATION;
import static uk.gov.di.test.acceptance.AccountJourneyPages.ACCOUNT_EXISTS;
import static uk.gov.di.test.acceptance.AccountJourneyPages.CHANGE_PASSWORD;
import static uk.gov.di.test.acceptance.AccountJourneyPages.DELETE_ACCOUNT;
import static uk.gov.di.test.acceptance.AccountJourneyPages.ENTER_PASSWORD_CHANGE_PASSWORD;
import static uk.gov.di.test.acceptance.AccountJourneyPages.ENTER_PASSWORD_DELETE_ACCOUNT;
import static uk.gov.di.test.acceptance.AccountJourneyPages.MANAGE_YOUR_ACCOUNT;
import static uk.gov.di.test.acceptance.AccountJourneyPages.PASSWORD_UPDATED_CONFIRMATION;
import static uk.gov.di.test.acceptance.SignInStepDefinitions.driver;

public class AxeStepDefinitions {
    @Given("a user navigates to the build account page")
    public void a_user_navigates_to_the_build_account_page() throws InterruptedException {
        driver.get("https://signin.build.account.gov.uk/");
        Thread.sleep(4000);
    }

    @When("a user runs accessibility tests")
    public void a_user_runs_accessibility_tests() {
        System.out.println("Salam2");
    }

    @Then("the user gets results")
    public void the_user_gets_results() {
        driver.quit();
    }
}
