package scripts;

import core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nttdata.pages.odshome.OdsHomePage;

public class OpenBankHomeTest extends TestBase<OdsHomePage> {

    @Test
    /*
    @Country("ES")
    @TestCase(
            ids = {"XRAY-xxxx"},
            country = "ES",
            language = "es",
            checkList = {
                    @Check(assertionName = "Link Containers are visible", jiraTestId = "XRAY-xxxx"),
                    @Check(assertionName = "Hazte Cliente Button is visible", jiraTestId = "XRAY-xxxx"),
                    @Check(assertionName = "Area Cliente Button is visible", jiraTestId = "XRAY-xxxx")
            }
    )
    */
    public void homeLinkTest() {
        controller.rejectCookies();
        boolean checkLinkContainers = controller.isVisibleLinkContainers();
        Assertions.assertTrue(checkLinkContainers, "Links items should be displayed on home page");
        boolean checkHazteClienteBtn = controller.isHazteClienteBtnVisible();
        Assertions.assertTrue(checkHazteClienteBtn, "Hazte Cliente button should be displayed");
        boolean checkAreaClientesBtn = controller.isAreaClientesBtnVisible();
        Assertions.assertTrue(checkAreaClientesBtn, "Area Clientes button should be displayed");
    }

    @Test
    /*
    @Country("ES")
    @TestCase(
            ids = {"XRAY-xxxx"},
            country = "ES",
            language = "es",
            checkList = {
                  @Check(assertionName =  "Charity Items are visible", jiraTestId="XRAY-xxxx")
            }
    )
    */
    public void charityItemsTest() {
        controller.acceptCookies();
        controller.clickOpenSolidaryBtn();
        boolean checkCharityItems = controller.isVisibleItemsWrapper();
        Assertions.assertTrue(checkCharityItems, "Charity items should be displayed on open charity page");
    }
}