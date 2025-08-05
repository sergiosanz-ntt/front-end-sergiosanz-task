package scripts;

import core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nttdata.pages.odshome.OdsHomePage;

public class OpenBankHomeTest extends TestBase<OdsHomePage> {

    @Test
    public void homeLinkTest() {
        controller.rejectCookies();
        boolean checkLinkContainers = controller.isVisibleLinkContainers();
        Assertions.assertTrue(checkLinkContainers, "Links items should be displayed on home page");
        boolean checkHazteClienteBtn = controller.isHazteClienteVisible();
        Assertions.assertTrue(checkHazteClienteBtn, "Hazte Cliente button should be displayed");
        boolean checkAreaClientesBtn = controller.isAreaClientesVisible();
        Assertions.assertTrue(checkAreaClientesBtn, "Area Clientes button should be displayed");
    }

    @Test
    public void charityItemsTest() {
        controller.acceptCookies();
        controller.clickOpenSolidaryBtn();
        boolean checkCharityItems = controller.isVisibleItemsWrapper();
        Assertions.assertTrue(checkCharityItems, "Charity items should be displayed on open charity page");
    }
}