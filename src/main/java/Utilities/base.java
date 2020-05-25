package Utilities;

import PageObjects.APIDemos.*;
import PageObjects.Calculator.AppMainPage;
import PageObjects.PHPTravels.*;
//import PageObjects.ExperiBank.*;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static Select dropDown;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static SoftAssert softAssertion = new SoftAssert();
    public static String Platform;

    public static MobileDriver mobileDriver;
    public static TouchAction touchAction;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    // Web
    public static homePage phpTravelsHome;
    public static signUpPage userLogin;
    public static resultsPage flightResults;
    public static bookingPage flightDetails;
    public static chatWindow liveChat;

    // Electron
    public static sideMenu sideMenuElec;
    public static communicationPage communicationElec;
    public static systemInfoPage systemInfoElec;

    // Desktop
    public static AppMainPage calcMain;
}
