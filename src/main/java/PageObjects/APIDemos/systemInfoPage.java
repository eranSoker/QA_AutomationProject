package PageObjects.APIDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class systemInfoPage
{
    @FindBy(id="screen-info-demo-toggle")
    public WebElement togl_ScreenInfo;

    @FindBy(id="screen-info")
    public WebElement btn_ViewDemo;

    @FindBy(id="got-screen-info")
    public WebElement txt_ScreenResolution;
}
