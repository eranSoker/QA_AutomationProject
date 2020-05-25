package PageObjects.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class bookingPage
{
    @FindBy(xpath="(//h5[@class='font-serif font400'])[1]")
    public WebElement txt_Summary;

    @FindBy(xpath="//p[@class='theme-search-results-item-flight-section-meta-time']")
    public WebElement txt_From;

    @FindBy(xpath="(//p[@class='theme-search-results-item-flight-section-meta-time'])[2]")
    public WebElement txt_To;

    @FindBy(className="absolute-right")
    public WebElement txt_Price;
}
