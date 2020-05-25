package PageObjects.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class homePage
{
    @FindBy(xpath="//div[@class='dropdown dropdown-currency']")
    public WebElement btn_Currency;

    @FindBy(xpath="//a[@class='dropdown-item text-center']")
    public List<WebElement> opt_Currency;

    @FindBy(xpath="//div[@class='dropdown dropdown-login dropdown-tab']")
    public WebElement btn_MyAccount;

    @FindBy(linkText="Sign Up")
    public WebElement btn_SignUp;

    @FindBy(xpath="//button[@aria-label='dismiss cookie message']")
    public WebElement btn_Cookies;

    @FindBy(linkText="FLIGHTS")
    public WebElement btn_Flights;

    @FindBy(xpath="(//div[@class='col-md-6 col-6'])[1]/div/div[2]/div/a")
    public WebElement btn_From;

    @FindBy(xpath="//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")
    public WebElement opt_FromCity;

    @FindBy(xpath="(//div[@class='col-md-6 col-6'])[2]/div/div[2]/div/a")
    public WebElement btn_To;

    @FindBy(xpath="//li[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")
    public WebElement opt_ToCity;

    @FindBy(xpath="//label[@class='custom-control-label' and @for='flightSearchRadio-1']")
    public WebElement rBtn_roundTrip;

    @FindBy(id="FlightsDateStart")
    public WebElement btn_Depart;

    @FindBy(xpath="//div[@class='datepicker -bottom-left- -from-bottom- active']/div/div/div[2]/div")
    public List<WebElement> list_Dates;

    @FindBy(id="FlightsDateEnd")
    public WebElement btn_Return;

    @FindBy(xpath="//div[@class='col-4']/div/div[2]/div/span/button")
    public WebElement btn_AdultsPlus;

    @FindBy(xpath="//button[@class='btn-primary btn btn-block']")
    public WebElement btn_Search;

    @FindBy(xpath="//i[@class='fab fa-twitter']")
    public WebElement btn_twitter;

    @FindBy(xpath="//i[@class='fab fa-facebook']")
    public WebElement btn_Facebook;
}
