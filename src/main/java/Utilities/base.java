package Utilities;

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
    public static ImageDiffer imgDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();
    public static SoftAssert softAssertion = new SoftAssert();
    public static String Platform;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stmt;
    public static ResultSet rs;

    // Web
    public static PageObjects.PHPTravels.homePage phpTravelsHome;
    public static PageObjects.PHPTravels.signUpPage userLogin;
    public static PageObjects.PHPTravels.resultsPage flightResults;
    public static PageObjects.PHPTravels.bookingPage flightDetails;
    public static PageObjects.PHPTravels.chatWindow liveChat;

    // Electron
    public static PageObjects.APIDemos.sideMenu sideMenuElec;
    public static PageObjects.APIDemos.communicationPage communicationElec;
    public static PageObjects.APIDemos.systemInfoPage systemInfoElec;

    // Desktop
    public static PageObjects.Calculator.AppMainPage calcMain;
}
