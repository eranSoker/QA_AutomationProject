package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class uiActions extends commonOps
{
    @Step("Click on Element")
    public static void click(WebElement elem)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Clear Text from Text-Field")
    public static void clear(WebElement elem)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }

    @Step("Send Text to Text-Field")
    public static void updateText(WebElement elem, String value)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step("Select option from DropDown")
    public static void updateDropDown(WebElement elem, String value)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        Select myValue = new Select(elem);
        myValue.selectByVisibleText(value);
    }

    @Step("Mouse Hover to Element")
    public static void mouseHoverElements(WebElement elem1, WebElement elem2)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Close popup")
    public static void closePopUp (WebElement elem)
    {
        try
        {
            if(Platform.equalsIgnoreCase("web"))
                wait.until(ExpectedConditions.elementToBeClickable(elem));
            elem.click();
        } catch (Exception e)
        {
            System.out.println("Popup is not found");
        }
    }

    @Step("Scroll To Element")
    public static void scrollToElement (WebElement elem)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    @Step("back To Default Content")
    public static void backToDefault ()
    {
        driver.switchTo().defaultContent();
    }

}
