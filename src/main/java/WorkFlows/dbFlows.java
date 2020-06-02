package WorkFlows;

import Extensions.dbActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.List;

public class dbFlows extends commonOps
{
    @Step("Create an account and sign up with DB credentials")
    public static void createAccountDB ()
    {
        List<String> cred = dbActions.getCredentials("SELECT firstName, lastName, phoneNumber, email, password FROM CredentialsDB WHERE id='4'");
        uiActions.click(phpTravelsHome.btn_MyAccount);
        uiActions.click(phpTravelsHome.btn_SignUp);
        uiActions.updateText(userLogin.txtField_FirstName, cred.get(0));
        uiActions.updateText(userLogin.txtField_LastName, cred.get(1));
        uiActions.updateText(userLogin.txtField_PhoneNumber, cred.get(2));
        uiActions.updateText(userLogin.txtField_Email, cred.get(3));
        uiActions.updateText(userLogin.txtField_password, cred.get(4));
        uiActions.updateText(userLogin.txtField_ConfirmPassword, cred.get(4));
        uiActions.closePopUp(phpTravelsHome.btn_Cookies);
        uiActions.click(userLogin.btn_SignUp);
    }
}
