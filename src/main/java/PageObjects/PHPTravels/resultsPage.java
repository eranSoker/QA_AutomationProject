package PageObjects.PHPTravels;

import Utilities.commonOps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class resultsPage extends commonOps
{
    @FindBy(xpath="//h3[@class='heading-title']")
    public WebElement txt_FromToTitle;

    @FindBy(xpath="//p[@class='text-muted post-heading']")
    public WebElement txt_NumOfResults;

    @FindBy(xpath="//ul[@id='LIST']/li")
    public List<WebElement> list_Results;

    private static final int flightResult = 1;
    @FindBy(xpath="(//button[@class='btn btn-primary btn-block theme-search-results-item-price-btn'])["+ flightResult +"]")
    public WebElement btn_BookFlight;

    @FindBy(xpath="//p[@class='theme-search-results-item-price-tag']["+ flightResult +"]")
    public WebElement txt_BookPrice;
}
