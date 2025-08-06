package stepsdef;

import core.CucumberTestBase;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.nttdata.pages.odshome.OdsHomePage;
import utilities.*;

import static org.nttdata.helpers.Runners.runAllureReport;

public class OpenBankSteps extends CucumberTestBase<OdsHomePage> {

    @Given("the user is on home page")
    public void user_is_on_home_page() {
    }

    @When("the user rejects the cookies")
    public void user_rejects_the_cookies() {
        controller.rejectCookies();
    }

    @When("the user accepts the cookies")
    public void user_accepts_the_cookies() {
        controller.acceptCookies();
    }

    @Then("the user clicks on open solidary button")
    public void the_user_clicks_on_open_solidary_button() {
        controller.clickOpenSolidaryBtn();
    }

    @And("the user checks the charity items")
    public void the_user_checks_the_charity_items() {
        boolean checkCharityItems = controller.isVisibleItemsWrapper();
        Assertions.assertTrue(checkCharityItems, "Charity items should be displayed on open charity page");
    }

    @Then("the user checks the link containers")
    public void user_checks_the_link_containers() {
        boolean checkLinkContainers = controller.isVisibleLinkContainers();
        Assertions.assertTrue(checkLinkContainers, "Links items should be displayed on home page");
    }

    @And("the user checks the navbar buttons")
    public void user_checks_the_navbar_buttons() {
        boolean checkHazteClienteBtn = controller.isHazteClienteBtnVisible();
        Assertions.assertTrue(checkHazteClienteBtn, "Hazte Cliente button should be displayed");
        boolean checkAreaClientesBtn = controller.isAreaClientesBtnVisible();
        Assertions.assertTrue(checkAreaClientesBtn, "Area Clientes button should be displayed");
    }

    @Before
    public void setUp(Scenario testInfo) {
        controller = createControllerInstance();
        ExtentReport.test = ExtentReport.getExtent().createTest(this.getClass().getSimpleName().concat("_").concat(testInfo.getName()));
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

    @After
    public void tearDown() {
//        Accessibility.checkAccessibility();
        NetworkLogs.getNetworkLogs();
        if (DriverConfiguration.getDriver() != null) {
            DriverConfiguration.quitDriver();
        }
    }
}
