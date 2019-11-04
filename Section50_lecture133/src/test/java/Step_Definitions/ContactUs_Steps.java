package Step_Definitions;

import Utils.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUs_Steps extends DriverFactory {
    @Given("^I access \"([^\"]*)\" contact us form$")
    public void i_access_contact_us_form(String url) throws Throwable {
        contactUsPage.getContactUsPage(url);
    }

    @When("^I enter a valid first name$")
    public void i_enter_a_valid_first_name() throws Exception {
        contactUsPage.enterFirstName("Luis Javier");
    }

    @And("^I enter a valid last name$")
    public void i_enter_a_valid_last_name(DataTable data_table) throws Exception {
        contactUsPage.enterLastName(data_table, 0, 1);
    }

    @And("^I enter a valid email address$")
    public void i_enter_a_valid_email_address()  {
        try {
            contactUsPage.enterEmailAddress("lmedina@belatrixsf.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I enter comments$")
    public void i_enter_comments(DataTable data_table)  {
        try {
            contactUsPage.enterComments(data_table, 0, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click on the sumit button$")
    public void i_click_on_the_sumit_button() throws Exception {
        contactUsPage.clickOnSubmitButton();
    }

    @Then("^the information should successfully be submitted via the contact us form\\.$")
    public void the_information_should_successfully_be_submitted_via_the_contact_us_form() throws InterruptedException {
        try {
            contactUsPage.confirmContactUsFormSubmissionWasSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}