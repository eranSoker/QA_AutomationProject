package PageObjects.PHPTravels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signUpPage
{
    @FindBy(name="firstname")
    public WebElement txtField_FirstName;

    @FindBy(name="lastname")
    public WebElement txtField_LastName;

    @FindBy(name="phone")
    public WebElement txtField_PhoneNumber;

    @FindBy(name="email")
    public WebElement txtField_Email;

    @FindBy(name="password")
    public WebElement txtField_password;

    @FindBy(name="confirmpassword")
    public WebElement txtField_ConfirmPassword;

    @FindBy(xpath="//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']")
    public WebElement btn_SignUp;

    @FindBy(className="text-align-left")
    public WebElement txt_UserName;
}
