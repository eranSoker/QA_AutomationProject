package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class desktopFlows extends commonOps
{
    @Step("Calculate Addition")
    public static void calculateValues (int num1, int num2, char operator)
    {
        uiActions.clickCalcNumber(num1);
        uiActions.clickCalcOperator(operator);
        uiActions.clickCalcNumber(num2);
        uiActions.click(calcMain.btnFun_Equals);
        uiActions.getResultCalc(calcMain.txt_Result);
    }
}
