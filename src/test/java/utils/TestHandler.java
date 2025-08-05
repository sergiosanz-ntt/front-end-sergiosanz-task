package utils;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import utilities.DriverConfiguration;
import utilities.ExtentReport;

public class TestHandler implements TestWatcher{

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ExtentReport.addMessage(Status.FAIL, "Test Failed: " + cause.getLocalizedMessage());
        ExtentReport.attachScreenshot(DriverConfiguration.getDriver());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        ExtentReport.addMessage(Status.PASS, "Test successfully passed");
    }
}
