package PageObjects.APIDemos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class communicationPage
{
    @FindBy(id="async-msg-demo-toggle")
    public WebElement togl_Asynchronous;

    @FindBy(id="async-msg")
    public WebElement btn_Ping;

    @FindBy(id="async-reply")
    public WebElement txt_PingReply;
}
