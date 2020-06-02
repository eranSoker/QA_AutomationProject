package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class desktopFlows extends commonOps
{
    @Step("Calculate Addition")
    public static void calculateValues (int num1, int num2, char operator)
    {
        clickCalcNumber(num1);
        clickCalcOperator(operator);
        clickCalcNumber(num2);
        uiActions.click(calcMain.btnFun_Equals);
        getResultCalc(calcMain.txt_Result);
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
            case 0:
                uiActions.click(calcMain.btnNum_Zero);
                break;
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
