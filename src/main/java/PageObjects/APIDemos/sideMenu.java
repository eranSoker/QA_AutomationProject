package PageObjects.APIDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class sideMenu
{
    @FindBy(id="button-windows")
    public WebElement btn_ManageWindows;

    @FindBy(id="button-ipc")
    public WebElement btn_Communication;

    @FindBy(id="button-app-sys-information")
    public WebElement btn_SystemInfo;
}
