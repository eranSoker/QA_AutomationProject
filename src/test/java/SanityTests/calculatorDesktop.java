package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.desktopFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class calculatorDesktop extends commonOps
{
    @Test(priority = 0, description = "Calculate Something")
    @Description("Test Description: Verify calculator functions and display result")
    public void calculate()
    {
        desktopFlows.calculateValues(6,9,'+');
        verifications.assertPartialTextInElement(calcMain.txt_Result,"15");
    }
}
