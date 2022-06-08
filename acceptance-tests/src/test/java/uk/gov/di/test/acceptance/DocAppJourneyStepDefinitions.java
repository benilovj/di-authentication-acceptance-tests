package uk.gov.di.test.acceptance;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

import static org.junit.Assert.assertTrue;

public class DocAppJourneyStepDefinitions extends SignInStepDefinitions {
    @Before
    public void setupWebdriver() throws MalformedURLException {
        super.setupWebdriver();
    }

    @Given("the authentication services are running")
    public void theAuthenticationServicesAreRunning() {}

    @And("the doc app user clears cookies")
    public void theClientClearsCookies() {
        driver.manage().deleteAllCookies();
    }

    @When("the doc app user visits the doc app stub relying party")
    public void theDocAppUserVisitsTheDocAppStubRelyingParty() {
        driver.get(DOC_APP_STUB_URL.toString());
    }

    @And("the doc app user clicks continue")
    public void theDocAppUserClicksContinue() {
        findAndClickContinue();
    }

    @Then("the doc app user is taken to the doc app cri stub")
    public void theDocAppUserItTakenToTheDocAppCriStub() {
        waitForPageLoad("GOV.UK");
        assertTrue(
                driver.getCurrentUrl()
                        .startsWith(
                                "https://build-doc-app-cri-stub.london.cloudapps.digital/authorize"));
    }
}

