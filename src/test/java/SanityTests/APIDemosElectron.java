package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.electronFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class APIDemosElectron extends commonOps
{
    @Test(priority = 1, description = "Reply pong")
    @Description("Test Description: Get message reply: pong")
    public void replyPong()
    {
        electronFlows.getReplyPong();
        verifications.assertPartialTextInElement(communicationElec.txt_PingReply, "pong");
    }

    @Test(priority = 2, description = "Screen Resolution")
    @Description("Test Description: Get screen resolution")
    public void screenResolution()
    {
        electronFlows.getScreenResolution();
        verifications.assertPartialTextInElement(systemInfoElec.txt_ScreenResolution, "1536px x 864px");
    }

    @Test(priority = 3, description = "ERROR")
    @Description("Test Description: ERROR occurred - screenshot is taken automatically")
    public void error()
    {
        verifications.assertPartialTextInElement(systemInfoElec.txt_ScreenResolution, "WRONG");
    }
}
