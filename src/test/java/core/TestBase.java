package core;

import com.aventstack.extentreports.ExtentReports;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import utilities.*;
import utils.TestHandler;

import java.lang.reflect.ParameterizedType;

import static org.nttdata.helpers.Runners.runAllureReport;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(TestHandler.class)
public class TestBase<T> {

    protected T controller;
    protected static ExtentReports extent;

    protected T createControllerInstance() {
        try {
            return ((Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create controller instance", e);
        }
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        controller = createControllerInstance();
        ExtentReport.test = ExtentReport.getExtent().createTest(this.getClass().getSimpleName().concat("_").concat(testInfo.getDisplayName()));
    }

    @BeforeAll
    public static void cleanReportsAndLogs() {
        JSExecutor.runCommand(
                LocalEnviroment.isWindows()
                        ? Constants.EXTENT_CLEAN_COMMAND_WIN
                        : Constants.EXTENT_CLEAN_COMMAND_MAC);
        extent = ExtentReport.setUpReport();
    }

    @AfterAll
    public static void runReports() {
        extent.flush();
        runAllureReport();
    }


    @AfterEach
    public void tearDown() {
//        Accessibility.checkAccessibility();
        NetworkLogs.getNetworkLogs();
        if (DriverConfiguration.getDriver() != null) {
            DriverConfiguration.quitDriver();
        }
    }
}
