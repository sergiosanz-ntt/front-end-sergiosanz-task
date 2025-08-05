package org.nttdata.pages.odshome;

import com.aventstack.extentreports.Status;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.ExtentReport;
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

    @FindBy(xpath = "//div[@data-testid='header-wrapper']//h1")
    protected WebElement charityHeader;

    //CSS Elements
    @FindBy(css = "#undefined-prospect-highlights a[data-testid=link-highlight]")
    protected List<WebElement> linkItems;

    @FindBy(css = ".button-footer-reject .container-cookie-modal-footer-button")
    protected WebElement rejectCookies;

    @FindBy(css = ".ok-middle-topbar__buttons-area div a")
    protected WebElement hazteClienteButton;

    @FindBy(css = ".ok-middle-topbar__buttons-area div button")
    protected WebElement areaClientesButton;

    public void acceptCookies(){
        clickWhenVisible(acceptCookiesBtn);
    }

    public void rejectCookies() {
        clickWhenVisible(rejectCookies);
    }

    public void clickOpenSolidaryBtn() {
        clickWhenVisible(openSolidaryBtn);
        waitForVisibility(charityHeader);
    }

    public boolean isVisibleItemsWrapper() {
        boolean checkItems = charityItems.stream().allMatch(WebElement::isDisplayed);
        ExtentReport.addMessage(Status.INFO, "All Charity Items should be visible: " + checkItems);
        return checkItems;
    }

    public boolean isVisibleLinkContainers() {
        boolean checkLinks = linkItems.stream().allMatch(WebElement::isDisplayed);
        ExtentReport.addMessage(Status.INFO, "All Links Containers should be visible: " + checkLinks);
        return checkLinks;
    }

    public boolean isHazteClienteVisible() {
        try {
            boolean check = hazteClienteButton.isDisplayed();
            ExtentReport.addMessage(Status.INFO, "Hazte cliente button should be displayed: " + check);
            return check;
        } catch (NoSuchElementException e) {
            ExtentReport.addMessage(Status.FAIL, "Hazte cliente button is not displayed");
            return false;
        }
    }

    public boolean isAreaClientesVisible() {
        try {
            boolean check = areaClientesButton.isDisplayed();
            ExtentReport.addMessage(Status.INFO, "Area Clientes Button should be displayed: " + check);
            return check;
        } catch (NoSuchElementException e) {
            ExtentReport.addMessage(Status.FAIL, "Area Clientes Button is not displayed: ");
            return false;
        }
    }

    public OdsHomePage() {
        WebDriver driver = DriverConfiguration.getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }
}
