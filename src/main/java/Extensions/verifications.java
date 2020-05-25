package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.*;

public class verifications extends commonOps
{
    @Step("Verify Condition is True")
    public static void assertTrueCondition (boolean bol)
    {
        assertTrue(bol);
    }

    @Step("Verify Element is Displayed")
    public static void assertElementIsDisplayed (WebElement elem)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify Partial Text in Element")
    public static void assertPartialTextInElement (WebElement elem, String expectedPartialText)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.getText().contains(expectedPartialText));
    }

    @Step("Verify Text in Element")
    public static void assertTextInElement (WebElement elem, String expectedValue)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify Text Equal between two Elements")
    public static void assertTextEqualElements (WebElement elem, WebElement elem2)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), elem2.getText());
    }

    @Step("Verify the number of Elements Equals to Value")
    public static void assertNumberOfElements (List<WebElement> elems, int expectedValue)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(), expectedValue);
    }

    @Step("Verify Element Visualy")
    public static void assertVisualElement (WebElement imageElememt, String expectedImageName) throws IOException
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("ImageRepo") + expectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading image file: " + e);
        }
        Screenshot imageScreenShot = new AShot().takeScreenshot(driver, imageElememt);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imgDiff.makeDiff(actualImage, expectedImage);
        assertFalse(diff.hasDiff(), "Images are not the same");
    }

    @Step("Verify Text to Text")
    public static void assertTextToText (String actualText, String expectedText)
    {
        assertEquals(actualText, expectedText);
    }


    //softAssertion

    @Step("Verify Condition is True")
    public static void softAssertTrueCondition (boolean bol)
    {
        softAssertion.assertTrue(bol);
    }

    @Step("Verify Element is Displayed")
    public static void softAssertElementIsDisplayed (WebElement elem)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        softAssertion.assertTrue(elem.isDisplayed());
    }

    @Step("Verify Partial Text in Element")
    public static void softAssertPartialTextInElement (WebElement elem, String expectedPartialText)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        softAssertion.assertTrue(elem.getText().contains(expectedPartialText));
    }

    @Step("Verify Text in Element")
    public static void softAssertTextInElement (WebElement elem, String expectedValue)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        softAssertion.assertEquals(elem.getText(), expectedValue);
    }

    @Step("Verify Text Equal between two Elements")
    public static void softAssertTextEqualElements (WebElement elem, WebElement elem2)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        softAssertion.assertEquals(elem.getText(), elem2.getText());
    }

    @Step("Verify the number of Elements Equals to Value")
    public static void softAssertNumberOfElements (List<WebElement> elems, int expectedValue)
    {
        if(Platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        softAssertion.assertEquals(elems.size(), expectedValue);
    }
}
