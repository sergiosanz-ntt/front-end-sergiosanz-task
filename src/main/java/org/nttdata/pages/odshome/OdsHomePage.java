package org.nttdata.pages.odshome;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class OdsHomePage extends FrontEndOperation {

    //Xpath Elements
    @FindBy(xpath = "//div[contains(@class, 'modal-footer-accept')]")
    protected WebElement acceptCookiesBtn;

    @FindBy(xpath = "//div[@id='id-homelinebanner']//a[@data-testid='gatsbyLink']")
    protected WebElement openSolidaryBtn;

    @FindBy(xpath = "//div[@data-testid='itemsWrapper']")
    protected List<WebElement> charityItems;

    //CSS Elements
    @FindBy(css = ".button-footer-reject .container-cookie-modal-footer-button")
    protected WebElement rejectCookies;

    public void acceptCookies(){
        clickWhenVisible(acceptCookiesBtn);
    }

    public void clickOpenSolidaryBtn() {
        clickWhenVisible(openSolidaryBtn);
    }

    public boolean checkVisibilityItemsCharity() {
        return charityItems.stream().allMatch(WebElement::isDisplayed);
    }

    public void rejectCookies() {
        clickWhenVisible(rejectCookies);
    }

    public OdsHomePage() {
        WebDriver driver = DriverConfiguration.getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }
}
