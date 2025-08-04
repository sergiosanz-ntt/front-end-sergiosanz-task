package org.nttdata.helpers;

import utilities.Accessibility;
import utilities.Constants;
import utilities.JSExecutor;
import utilities.LocalEnviroment;

public class Runners {
    public static void runAllureReport() {
        if (LocalEnviroment.isWindows()) {
            JSExecutor.runCommand(Constants.EXTENT_COMMAND_WIN);
        } else {
            JSExecutor.runCommand(Constants.EXTENT_COMMAND_MAC);
        }
    }

    public static void runAccessibilityCopy() {
        if (LocalEnviroment.getAccessibility() && LocalEnviroment.isWeb()) {
            Accessibility.moveHtmlReportToAccessibilityDirectory(Constants.ACCESSIBILITY_REPORT_PATH);
        }
    }
}
