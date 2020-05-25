package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

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
        driver.switchTo().defaultContent();
    }

    @Step("Get Result From Calculator")
    public static void getResultCalc (WebElement elem)
    {
        elem.getText().replace("Display is", "").trim();
    }

    @Step("Click On Operator Calculator")
    public static void clickCalcOperator (char operator)
    {
        if (operator == '+')
            uiActions.click(calcMain.btnFun_Plus);
        else if (operator == '-')
            uiActions.click(calcMain.btnFun_Minus);
        else if (operator == '/')
            uiActions.click(calcMain.btnFun_Divide);
        else if (operator == '*')
            uiActions.click(calcMain.btnFun_Multiply);
        else
            System.out.println("Missing valid operator");
    }

    @Step("Click On Number Calculator")
    public static void clickCalcNumber (int num)
    {
        switch (num)
        {
            case 1:
                uiActions.click(calcMain.btnNum_One);
                break;
            case 2:
                uiActions.click(calcMain.btnNum_Two);
                break;
            case 3:
                uiActions.click(calcMain.btnNum_Three);
                break;
            case 4:
                uiActions.click(calcMain.btnNum_Four);
                break;
            case 5:
                uiActions.click(calcMain.btnNum_Five);
                break;
            case 6:
                uiActions.click(calcMain.btnNum_Six);
                break;
            case 7:
                uiActions.click(calcMain.btnNum_Seven);
                break;
            case 8:
                uiActions.click(calcMain.btnNum_Eight);
                break;
            case 9:
                uiActions.click(calcMain.btnNum_Nine);
                break;
        }
    }
}
