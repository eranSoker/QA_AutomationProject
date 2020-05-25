package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.dbFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class remotemysqlDB extends commonOps
{
    @Test(priority = 1, description = "Create New User with DB credentials")
    @Description("Test Description: Create New User with DB credentials")
    public void createUserDB()
    {
        dbFlows.createAccountDB();
        verifications.assertTextInElement(userLogin.txt_UserName, "Hi, Eran Soker");
    }
}
