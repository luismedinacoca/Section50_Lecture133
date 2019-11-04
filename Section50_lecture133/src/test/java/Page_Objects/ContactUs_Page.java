package Page_Objects;

import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ContactUs_Page extends BasePage{
    /** Contact Us Page Locators: **/
    public @FindBy(xpath = "//input[@name='first_name']") WebElement textField_FirstName;
    public @FindBy(xpath = "//input[@name = 'last_name']") WebElement textField_LastName;
    public @FindBy(xpath = "//input[@name = 'email']") WebElement textField_EmailAddress;
    public @FindBy(xpath = "//textarea[@name = 'message']") WebElement textField_Message;
    public @FindBy(xpath = "//input[@value = 'SUBMIT']") WebElement button_Submit;
    public @FindBy(xpath = "//input[@value = 'RESET']") WebElement button_Reset;

    public ContactUs_Page() throws IOException {
        super();
    }

    public void getContactUsPage(String url) throws IOException, InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(5000);
    }

    public void enterFirstName(String firstName) throws Exception{
        sendKeysToWebElement(textField_FirstName, firstName);
    }

    public void enterLastName(DataTable data_table, int row, int column) throws Exception {
        List<List<String>> data = data_table.raw();
        sendKeysToWebElement(textField_LastName, data_table.raw().get(row).get(column));
    }

    public void enterEmailAddress(String emailAddress) throws Exception{
        sendKeysToWebElement(textField_EmailAddress, emailAddress);
    }

    public void enterComments(DataTable dataTable, int row, int column) throws Exception{
        List<List<String>> data = dataTable.raw();
        sendKeysToWebElement(textField_Message, data.get(row).get(column));
    }

    public void clickOnSubmitButton() throws Exception {
        waitAndClickElement(button_Submit);
    }

    public void clickOnResetButton() throws Exception {
        waitAndClickElement(button_Reset);
    }

    public void confirmContactUsFormSubmissionWasSuccessful() throws Exception {
        WebElement thanksContactUsPage = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
        WaitUntilWebElementIsVisible(thanksContactUsPage);
        Assert.assertEquals("thankyouforyourmessage!", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
    }
}