package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class electronFlows extends commonOps
{
    @Step("Get message reply: pong")
    public static void getReplyPong ()
    {
        uiActions.click(sideMenuElec.btn_ManageWindows);
        uiActions.click(sideMenuElec.btn_Communication);
        uiActions.click(communicationElec.togl_Asynchronous);
        uiActions.click(communicationElec.btn_Ping);
    }

    @Step("Get message reply: pong")
    public static void getScreenResolution ()
    {
        uiActions.click(sideMenuElec.btn_SystemInfo);
        uiActions.click(systemInfoElec.togl_ScreenInfo);
        uiActions.click(systemInfoElec.togl_ScreenInfo);
        uiActions.click(systemInfoElec.btn_ViewDemo);
    }
}
