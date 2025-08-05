package scripts;

import core.GenericTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.nttdata.pages.odshome.OdsHomePage;

public class OpenBankHomeTest extends GenericTest<OdsHomePage> {

    @Test
    public void xpathLocatorTest() {
        controller.acceptCookies();
        controller.clickOpenSolidaryBtn();
        boolean checkCharityItems = controller.checkVisibilityItemsCharity();
        Assertions.assertTrue(checkCharityItems, "All items should be displayed on open charity page");
    }

    @Test
    public void cssLocatorTest() {
        controller.rejectCookies();
        controller.clickOpenSolidaryBtn();
    }
}
