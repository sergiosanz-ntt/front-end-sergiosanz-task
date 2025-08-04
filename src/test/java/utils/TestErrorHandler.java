package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import utilities.DriverConfiguration;
import utilities.ExtentReport;

public class TestErrorHandler implements TestWatcher{

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentReport.attachScreenshot(DriverConfiguration.getDriver());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
//        ExtentReport.attachScreenshot(DriverConfiguration.getDriver());
    }
}
