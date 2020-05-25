package PageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppMainPage
{
    @FindBy(xpath="//*[@AutomationId='CalculatorResults']")
    public WebElement txt_Result;

    @FindBy(name="Clear")
    public WebElement btnFun_Clear;

    @FindBy(name="Plus")
    public WebElement btnFun_Plus;

    @FindBy(name="Minus")
    public WebElement btnFun_Minus;

    @FindBy(xpath="//*[@name='Multiply by']")
    public WebElement btnFun_Multiply;

    @FindBy(xpath="//*[@name='Divide by']")
    public WebElement btnFun_Divide;

    @FindBy(name="Equals")
    public WebElement btnFun_Equals;

    @FindBy(name="Zero")
    public WebElement btnNum_Zero;

    @FindBy(name="One")
    public WebElement btnNum_One;

    @FindBy(name="Two")
    public WebElement btnNum_Two;

    @FindBy(name="Three")
    public WebElement btnNum_Three;

    @FindBy(name="Four")
    public WebElement btnNum_Four;

    @FindBy(name="Five")
    public WebElement btnNum_Five;

    @FindBy(name="Six")
    public WebElement btnNum_Six;

    @FindBy(name="Seven")
    public WebElement btnNum_Seven;

    @FindBy(name="Eight")
    public WebElement btnNum_Eight;

    @FindBy(name="Nine")
    public WebElement btnNum_Nine;
}

