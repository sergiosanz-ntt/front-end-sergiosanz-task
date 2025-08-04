package org.nttdata.pages.odshome;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import utilities.Constants;
import utilities.DriverConfiguration;
import utilities.FrontEndOperation;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class OdsHomePage extends FrontEndOperation {

    public OdsHomePage() {
        WebDriver driver = DriverConfiguration.getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }
}
