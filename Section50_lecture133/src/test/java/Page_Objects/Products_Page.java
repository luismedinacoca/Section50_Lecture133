package Page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;

public class Products_Page extends BasePage{
    /** Locators **/
    public @FindBy(xpath = "//*[@id='container-special-offers']")
    WebElement button_SpecialOffers;
    public @FindBy(xpath = "//*[@id='cameras']") WebElement button_Camara;
    public @FindBy(xpath = "//*[@id='container-product2']") WebElement button_NewLaptops;
    public @FindBy(xpath = "//*[@id='container-product3']") WebElement button_UsedLaptops;
    public @FindBy(xpath = "//*[@id='container-product4']") WebElement button_GameConsoles;
    public @FindBy(xpath = "//*[@id='container-product5']") WebElement button_Components;
    public @FindBy(xpath = "//*[@id='container-product6']") WebElement button_DesktopSystems;
    public @FindBy(xpath = "//*[@id='container-product7']") WebElement button_Audio;
    public @FindBy(xpath = "//*[@id='myModal']//b[contains(text(),'NEWCUSTOMER')]") WebElement voucherCode;
    public @FindBy(xpath = "//button[text()='Proceed']") WebElement button_Proceed_Popup;

    public Products_Page() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedButton_Popup() throws InterruptedException {
        waitAndClickElement(button_Proceed_Popup);
    }

    public String printSpecialOffersVoucherCode(){
        WaitUntilWebElementIsVisible(voucherCode);
        String voucherCodeValue = voucherCode.getText();
        System.out.println("voucher code: " + voucherCode.getText());
        return voucherCodeValue;
    }
}
