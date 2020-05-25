package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps
{
    @Step("Get Credentials from DB")
    public static List<String> getCredentials (String query)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {
            rs = stmt.executeQuery(query);
            rs.next();
            for (int i=1; i<6; i++)
            {
                credentials.add(rs.getString(i));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error occurred while import data from DB, see details: " + e);
        }
        return credentials;
    }
}
