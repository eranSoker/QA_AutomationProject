package Utilities;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.sql.DriverManager;

public class manageDB extends commonOps
{
    @Step("Connect to Data Base")
    @Description("Step Description: Connect to Data Base according to the dbURL in DataConfig.xml file")
    public static void initDB(String dbURL, String user, String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            System.out.println("Error occurred trying to connect DB, see details: " + e);
        }
    }

    @Step("Disconnect from Data Base")
    @Description("Step Description: Disconnect from Data Base - dbURL in DataConfig.xml file")
    public static void closeDBConnection()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error occurred trying to close connection to DB, see details: " + e);
        }
    }
}
