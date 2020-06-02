package Utilities;

import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    @Step("Get Data")
    @Description("Step Description: Get data from DataConfig.xml file")
    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        finally
        {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    @Step("Choose Browser")
    @Description("Step Description: Choosing the right browser according to the value in DataConfig.xml file")
    public static void initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid browserType");
        driver.manage().window().maximize();
        driver.get(getData("url"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
        action = new Actions(driver);
    }

    @Step("Chrome Driver Setup")
    @Description("Step Description: Automatic setup to chrome driver")
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    @Step("Firefox Driver Setup")
    @Description("Step Description: Automatic setup to firefox driver")
    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    @Step("Internet Explorer Driver Setup")
    @Description("Step Description: Automatic setup to internet explorer driver")
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @Step("API Platform")
    @Description("Step Description: Login to API using RestAssured according to the url in DataConfig.xml file")
    public static void initAPI()
    {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("userNameAPI"),getData("passwordAPI"));
    }

    @Step("Electron Platform")
    @Description("Step Description: Login to Electron app according to the app path in DataConfig.xml file")
    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }

    @Step("Desktop Platform")
    @Description("Step Description: Login to Desktop app according to the App Unique in DataConfig.xml file")
    public static void initDesktop()
    {
        dc.setCapability("app", getData("AppUnique"));
        try
        {
            driver = new WindowsDriver(new URL(getData("WinAppDriver")), dc);
        }
        catch (Exception e)
        {
            System.out.println("Can NOT connect to Appium server - Desktop App, See Details: " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }

    @BeforeClass
    @Parameters({"PlatformName"})
    @Description("Step Description: Executed once and before all tests in the class")
    public void startSession (String PlatformName)
    {
        Platform = PlatformName;
        if(Platform.equalsIgnoreCase("web"))
        {
            initBrowser(getData("BrowserName"));
            managePages.initWeb();
        }
        else if(Platform.equalsIgnoreCase("api"))
        {
            initAPI();
        }
        else if(Platform.equalsIgnoreCase("electron"))
        {
            initElectron();
            managePages.initElec();
        }
        else if(Platform.equalsIgnoreCase("desktop"))
        {
            initDesktop();
            managePages.initDesk();
        }
        else
        {
            throw new RuntimeException("Invalid platform");
        }
        manageDB.initDB(getData("dbURL"), getData("dbUser"), getData("dbPassword"));
    }

    @AfterMethod
    @Description("Step Description: Invoked after the execution of each test method in the class")
    public void afterMethod() throws MalformedURLException
    {
        if(Platform.equalsIgnoreCase("web"))
            driver.get(getData("url"));
    }

    @AfterClass
    @Description("Step Description: Executed once and after all tests in the class")
    public void closeSession()
    {
        manageDB.closeDBConnection();
        if(!Platform.equalsIgnoreCase("api"))
            driver.quit();
    }
}
