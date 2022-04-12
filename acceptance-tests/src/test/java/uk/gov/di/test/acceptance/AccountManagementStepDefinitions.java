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
import static uk.gov.di.test.acceptance.AccountJourneyPages.RESET_PASSWORD;
import static uk.gov.di.test.acceptance.AuthenticationJourneyPages.CHECK_YOUR_PHONE;

public class AccountManagementStepDefinitions extends SignInStepDefinitions {

    private String emailAddress;
    private String password;
    private String newPassword;
    private String newEmailAddress;
    private String newPhoneNumber;
    private String sixDigitCodeEmail;
    private String resetPassword;
    private String sixDigitCodePhone;

    @Before
    public void setupWebdriver() throws MalformedURLException {
        super.setupWebdriver();
    }

    @Given("the account management services are running")
    public void theServicesAreRunning() {}

    @And("the existing account management user has valid credentials")
    public void theExistingAccountManagementUserHasValidCredentials() {
        emailAddress = System.getenv().get("TEST_USER_EMAIL");
        password = System.getenv().get("TEST_USER_PASSWORD");
        newEmailAddress = System.getenv().get("TEST_USER_NEW_EMAIL");
        newPhoneNumber = System.getenv().get("TEST_USER_NEW_PHONE_NUMBER");
        sixDigitCodeEmail = System.getenv().get("TEST_USER_EMAIL_CODE");
        resetPassword = System.getenv().get("TEST_USER_RESET_PASSWORD");
        sixDigitCodePhone = System.getenv().get("TEST_USER_PHONE_CODE");
    }

    @When("the existing account management user navigates to account management")
    public void theExistingAccountManagementUserVisitsTheStubRelyingParty() {
        driver.get(AM_URL.toString());
    }

    @Then("the existing account management user is taken to the manage your account page")
    public void theExistingAccountManagementUserIsTakenToTheManageYourAccountPage() {
        waitForPageLoadThenValidate(MANAGE_YOUR_ACCOUNT);
    }

    @When("the existing account management user clicks link by href {string}")
    public void theUserClicksLinkByHref(String href) {
        driver.findElement(By.xpath("//a[@href=\"" + href + "\"]")).click();
    }

    @Then("the existing account management user is asked to enter their current password")
    public void theExistingAccountManagementUserIsAskedToEnterTheirCurrentPassword() {
        waitForPageLoadThenValidate(ENTER_PASSWORD_CHANGE_PASSWORD);
    }

    @When("the existing account management user enter their current password")
    public void theExistingAccountManagementUserEntersTheirCurrentPassword() {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
        findAndClickContinue();
    }

    @Then("the existing account management user is taken to the change password page")
    public void theExistingAccountManagementUserIsTakenToTheChangePassword() {
        waitForPageLoadThenValidate(CHANGE_PASSWORD);
    }

    @When("the existing account management user uses their updated password")
    public void theExistingAccountManagementUserChoosesANewPassword() {
        newPassword = System.getenv().get("TEST_USER_NEW_PASSWORD");
    }

    @And("the existing account management user enters their updated password")
    public void theExistingAccountManagementUserEntersTheirNewPassword() {
        WebElement enterPasswordField = driver.findElement(By.id("password"));
        enterPasswordField.sendKeys(newPassword);
        WebElement confirmPasswordField = driver.findElement(By.id("confirm-password"));
        confirmPasswordField.sendKeys(newPassword);
        findAndClickContinue();
    }

    @And("the existing account management user enters their updated password to delete account")
    public void theExistingAccountManagementUserEntersTheirUpdatedPasswordToDeleteAccount() {
        WebElement enterPasswordField = driver.findElement(By.id("password"));
        enterPasswordField.sendKeys(newPassword);
        findAndClickContinue();
    }

    @Then("the existing account management user is taken to password updated confirmation page")
    public void theExistingAccountManagementUserIsTakenToThePasswordUpdatedConfirmation() {
        waitForPageLoadThenValidate(PASSWORD_UPDATED_CONFIRMATION);
    }

    @Then("the existing account management user is asked to enter their password")
    public void theExistingAccountManagementUserIsAskedToEnterTheirPassword() {
        waitForPageLoadThenValidate(ENTER_PASSWORD_DELETE_ACCOUNT);
    }

    @Then("the existing account management user is taken to the delete account page")
    public void theExistingAccountManagementUserIsTakenToTheDeleteAccountPage() {
        waitForPageLoadThenValidate(DELETE_ACCOUNT);
    }

    @Then("the existing account management user is taken to the account deleted confirmation page")
    public void theExistingAccountManagementUserIsTakenToTheAccountDeletedConfirmationPage() {
        waitForPageLoadThenValidate(ACCOUNT_DELETED_CONFIRMATION);
    }

    @When("the user clicks button by text {}")
    public void theUserClicksButtonByText(String buttonText) {
        findAndClickButtonByText(buttonText);
    }

    private void waitForPageLoadThenValidate(AccountJourneyPages page) {
        waitForPageLoad(page.getShortTitle());
        assertEquals(page.getRoute(), URI.create(driver.getCurrentUrl()).getPath());
        assertEquals(page.getFullTitle(), driver.getTitle());
    }

    @And("the existing account management user selects create an account")
    public void theExistingAccountManagementUserSelectsCreateAnAccount() {
        WebElement link = driver.findElement(By.id("create-account-link"));
        link.click();
    }

    @Then("the exiting account management user is asked to enter their current email address")
    public void theExitingAccountManagementUserIsAskedToEnterTheirCurrentEmailAddress() {
        waitForPageLoadThenValidate(AuthenticationJourneyPages.ENTER_EMAIL_CREATE);
    }

    @When("the existing account management user enters their current email address")
    public void theExistingAccountManagementUserEntersTheirCurrentEmailAddress() {
        WebElement passwordField = driver.findElement(By.id("email"));
        passwordField.sendKeys(emailAddress);
        findAndClickContinue();
    }

    @Then("the existing account management user is taken to the account exists page")
    public void theExistingAccountManagementUserIsTakenToTheAccountExistsPage() {
        waitForPageLoadThenValidate(ACCOUNT_EXISTS);
    }

    @When("the existing account management user selects sign in")
    public void theExistingAccountManagementUserSelectsSignIn() {
        WebElement link = driver.findElement(By.id("sign-in-link"));
        link.click();
    }

    @Then("the existing account management user is asked to enter their email code")
    public void theExistingAccountManagementUserIsAskedToEnterTheirEmailCode() {
        WebElement enterCodeField = driver.findElement(By.id("code"));
        enterCodeField.clear();
        enterCodeField.sendKeys(sixDigitCodeEmail);
        findAndClickContinue();
    }

    @Then("the existing account management user is taken to the reset password page")
    public void theExistingAccountManagementUserIsTakenToTheResetPasswordPage() {
        waitForPageLoadThenValidate(RESET_PASSWORD);
    }

    @When("the existing account management user uses their reset password")
    public void theExistingAccountManagementUserUsesTheirResetPassword() {
        resetPassword = System.getenv().get("TEST_USER_RESET_PASSWORD");
    }

    @And("the existing account management user enters their reset password")
    public void theExistingAccountManagementUserEntersTheirResetPassword() {
        WebElement enterPasswordField = driver.findElement(By.id("password"));
        enterPasswordField.sendKeys(resetPassword);
        WebElement confirmPasswordField = driver.findElement(By.id("confirm-password"));
        confirmPasswordField.sendKeys(resetPassword);
        findAndClickContinue();
    }

    @Then("the existing account management user is taken to the check your phone page")
    public void theExistingAccountManagementUserIsTakenToTheCheckYourPhonePage() {
        waitForPageLoadThenValidate(CHECK_YOUR_PHONE);
    }

    @When("the existing account management user enters their phone code")
    public void theExistingAccountManagementUserEntersTheirPhoneCode() {
        WebElement enterCodeField = driver.findElement(By.id("code"));
        enterCodeField.clear();
        enterCodeField.sendKeys(sixDigitCodePhone);
        findAndClickContinue();
    }

    @And("the existing account management user enters their reset password to delete account")
    public void theExistingAccountManagementUserEntersTheirResetPasswordToDeleteAccount() {
        WebElement enterPasswordField = driver.findElement(By.id("password"));
        enterPasswordField.sendKeys(resetPassword);
        findAndClickContinue();
    }
}
