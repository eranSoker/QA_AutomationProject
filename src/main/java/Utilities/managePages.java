package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void initWeb()
    {
        phpTravelsHome = PageFactory.initElements(driver, PageObjects.PHPTravels.homePage.class);
        userLogin = PageFactory.initElements(driver, PageObjects.PHPTravels.signUpPage.class);
        flightResults = PageFactory.initElements(driver, PageObjects.PHPTravels.resultsPage.class);
        flightDetails = PageFactory.initElements(driver, PageObjects.PHPTravels.bookingPage.class);
        liveChat = PageFactory.initElements(driver, PageObjects.PHPTravels.chatWindow.class);
    }


    public static void initElec()
    {
        sideMenuElec = PageFactory.initElements(driver, PageObjects.APIDemos.sideMenu.class);
        communicationElec = PageFactory.initElements(driver, PageObjects.APIDemos.communicationPage.class);
        systemInfoElec = PageFactory.initElements(driver, PageObjects.APIDemos.systemInfoPage.class);
    }

    public static void initDesk()
    {
        calcMain = PageFactory.initElements(driver, PageObjects.Calculator.AppMainPage.class);
    }

}
