package SanityTests;

import Extensions.*;
import Utilities.commonOps;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static WorkFlows.webFlows.*;

@Listeners(Utilities.listeners.class)
public class phpTravelsWeb extends commonOps
{
    @Test(priority = 1, description = "Create New User")
    @Description("Test Description: Create New User")
    public void createUser()
    {
        createAccount();
        verifications.assertTextInElement(userLogin.txt_UserName, "Hi, "+getData("firstName")+" "+getData("lastName"));
    }

    @Test(priority = 2, description = "Choose A Flight")
    @Description("Test Description: Choosing A Flight from one Destination to second Destination for 2 passenger and Verify the Number of Results")
    public void chooseFlight()
    {
        chooseAFlight();
        verifications.softAssertElementIsDisplayed(flightResults.txt_FromToTitle);
        verifications.softAssertNumberOfElements(flightResults.list_Results, Integer.parseInt(flightResults.txt_NumOfResults.getText().replace(" Total listings found","")));
        softAssertion.assertAll();
    }

    @Test(priority = 3, description = "Book A Deal")
    @Description("Test Description: book a deal and make sure the details are match to actual result")
    public void bookDeal() throws InterruptedException
    {
        changeCurrency();
        chooseAFlight();
        String flightPrice = flightResults.txt_BookPrice.getText();
        bookADeal();
        verifications.softAssertTextInElement(flightDetails.txt_Summary,"Booking Summary");
        verifications.softAssertTrueCondition(flightDetails.txt_From.getText().equalsIgnoreCase(getData("from")));
        verifications.softAssertTrueCondition(flightDetails.txt_To.getText().equalsIgnoreCase(getData("to")));
        verifications.softAssertTextInElement(flightDetails.txt_Price, flightPrice);
        softAssertion.assertAll();
    }

    @Test(priority = 4, description = "Write Message in the Live Chat")
    @Description("Test Description: write a short message in the Live Chat")
    public void liveChatMessage()
    {
        messageInChat();
        verifications.softAssertElementIsDisplayed(liveChat.img_messageSent);
        verifications.softAssertPartialTextInElement(liveChat.txt_Delivered, "wrong word");
        System.out.println(liveChat.txt_Delivered.getText());
        softAssertion.assertAll();
        driver.switchTo().defaultContent();
    }

    @Test(priority = 5, description = "Twitter Link")
    @Description("Test Description: Check that Twitter link is working")
    public void twitterSync()
    {
        checkLink(phpTravelsHome.btn_twitter);
        verifications.assertTextToText(driver.getCurrentUrl(),getData("twitterUrl"));
    }
}
