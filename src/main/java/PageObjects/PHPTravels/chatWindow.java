package PageObjects.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class chatWindow
{
    @FindBy(xpath="//iframe[@id='chat-widget']")
    public WebElement ifrm;

    @FindBy(xpath="//button[@class='lc-1jq1bpl e1m5b1js0']")
    public WebElement btn_Chat;

    @FindBy(xpath="//button[@class='lc-3a63hl esv0owm0']")
    public WebElement btn_ChatNow;

    @FindBy(xpath="//input[@id='name']")
    public WebElement txtField_Name;

    @FindBy(xpath="(//input[@class='lc-1gz7fd7 e1xplv9i0'])[2]")
    public WebElement txtField_WhatsApp ;

    @FindBy(xpath="//input[@id='email']")
    public WebElement txtField_Email;

    @FindBy(xpath="(//div[@class='lc-qvffge e108e6fy0'])[4]/div/input")
    public WebElement txtField_Subject;

    @FindBy(xpath="//select[@class='lc-jjhb0i egtcv0s1']")
    public WebElement select_existingClient;

    @FindBy(xpath="//button[@class='lc-3a63hl esv0owm0']")
    public WebElement btn_StartChat;

    @FindBy(xpath="//div[@class='lc-1wy764u e1q4zsg91']")
    public WebElement img_messageSent;

    @FindBy(tagName="textarea")
    public WebElement txtArea_Message;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement btn_SendMessage;

    @FindBy(xpath="//span[@class='Linkify' and contains(text(),'Thank you')]")
    public WebElement txt_Delivered;
}
