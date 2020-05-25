package Utilities;

import java.sql.DriverManager;

public class manageDB extends commonOps
{
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
