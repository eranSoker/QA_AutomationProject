package WorkFlows;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class webFlows extends commonOps
{
    @Step("Create an account and sign up")
    public static void createAccount ()
    {
        uiActions.click(phpTravelsHome.btn_MyAccount);
        uiActions.click(phpTravelsHome.btn_SignUp);
        uiActions.updateText(userLogin.txtField_FirstName, getData("firstName"));
        uiActions.updateText(userLogin.txtField_LastName, getData("lastName"));
        uiActions.updateText(userLogin.txtField_PhoneNumber, getData("phoneNumber"));
        uiActions.updateText(userLogin.txtField_Email, getData("email"));
        uiActions.updateText(userLogin.txtField_password, getData("password"));
        uiActions.updateText(userLogin.txtField_ConfirmPassword, getData("password"));
        uiActions.closePopUp(phpTravelsHome.btn_Cookies);
        uiActions.click(userLogin.btn_SignUp);
    }

    @Step("Choose a flight")
    public static void chooseAFlight ()
    {
        uiActions.closePopUp(phpTravelsHome.btn_Cookies);
        uiActions.click(phpTravelsHome.btn_Flights);
        uiActions.click(phpTravelsHome.rBtn_roundTrip);
        uiActions.click(phpTravelsHome.btn_From);
        uiActions.updateText(phpTravelsHome.btn_From, getData("from"));
        uiActions.mouseHoverElements(phpTravelsHome.btn_Flights, phpTravelsHome.opt_FromCity);
        uiActions.click(phpTravelsHome.btn_To);
        uiActions.updateText(phpTravelsHome.btn_To, getData("to"));
        uiActions.mouseHoverElements(phpTravelsHome.btn_To, phpTravelsHome.opt_ToCity);
        uiActions.click(phpTravelsHome.btn_Depart);
        for(WebElement date: phpTravelsHome.list_Dates)
        {
            if (date.getAttribute("class").contains("current"))
            {
                uiActions.mouseHoverElements(phpTravelsHome.btn_Depart, date);
                break;
            }
        }

        for(WebElement date: phpTravelsHome.list_Dates)
        {
            if (date.getAttribute("class").contains("current"))
            {
                WebElement returnDate = date.findElement(By.xpath("following-sibling::div["+getData("numberOfDays")+"]"));
                uiActions.mouseHoverElements(phpTravelsHome.btn_Return, returnDate);
                break;
            }
        }
        uiActions.click(phpTravelsHome.btn_AdultsPlus);
        uiActions.click(phpTravelsHome.btn_Search);
    }

    @Step("Select one deal and book")
    public static void bookADeal ()
    {
        uiActions.click(flightResults.btn_BookFlight);
    }

    @Step("Change currency")
    public static void changeCurrency () throws InterruptedException
    {
        uiActions.click(phpTravelsHome.btn_Currency);
        for (WebElement currency: phpTravelsHome.opt_Currency)
        {
            if (currency.getText().equals(getData("currency")))
            {
                uiActions.click(currency);
                break;
            }
        }
        Thread.sleep(1000);
    }

    @Step("Send message in chat")
    public static void messageInChat ()
    {
        uiActions.closePopUp(phpTravelsHome.btn_Cookies);
        driver.switchTo().frame(liveChat.ifrm);
        uiActions.click(liveChat.btn_Chat);
        try
        {
            uiActions.click(liveChat.btn_ChatNow);
        }
        catch (Exception e){
            System.out.println("The button wasn't there");
        }
        uiActions.updateText(liveChat.txtField_Name, getData("firstName"));
        uiActions.updateText(liveChat.txtField_Email, getData("email"));
        uiActions.updateText(liveChat.txtField_Subject, getData("subject"));
        try
        {
            dropDown = new Select(liveChat.select_existingClient);
            dropDown.selectByVisibleText("No");
            uiActions.click(liveChat.btn_StartChat);        }
        catch (Exception e){
            System.out.println("DropDown wasn't there");
        }
        uiActions.updateText(liveChat.txtArea_Message, getData("message"));
        uiActions.click(liveChat.btn_SendMessage);
    }

    @Step("Check Link is working")
    public static void checkLink (WebElement elem)
    {
        uiActions.scrollToElement(elem);
        uiActions.click(elem);
        GetUrlAndMatch(getData("twitterUrl"));
    }

    @Step("Get Get Url And Match")
    public static void GetUrlAndMatch (String url)
    {
        Set<String> winHandles = driver.getWindowHandles();
        for (String winHandle : winHandles)
        {
            driver.switchTo().window(winHandle);
            if(driver.getTitle().contains(getData("urlTitle")))
                break;
        }
        verifications.assertTrueCondition(driver.getCurrentUrl().equals((url)));
    }
}
