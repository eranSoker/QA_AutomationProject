package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class grafanaAPI extends commonOps
{
    @Test(priority = 1, description = "Add New Team And Verify")
    @Description("Test Description: Add new team and verify it")
    public void addTeamAndVerify()
    {
        apiFlows.postTeam("EranTeam", "eran@team.com");
        verifications.assertTextToText(apiFlows.getTeamProperty("teams[0].name"),"EranTeam");
    }

    @Test(priority = 2, description = "Get Team Property")
    @Description("Test Description: Get one property from team")
    public void getTeamProperty()
    {
        verifications.assertTextToText(apiFlows.getTeamProperty("teams[0].email"),"eran@team.com");
    }

    @Test(priority = 3, description = "Update Team Properties And Verify")
    @Description("Test Description: Update team Properties and verify it")
    public void updateTeamAndVerify()
    {
        apiFlows.updateTeam("JuneTeam", "juneteam@team.com");
        verifications.assertTextToText(apiFlows.getTeamProperty("teams[0].name"),"JuneTeam");
    }

    @Test(priority = 4, description = "Delete Team And Verify")
    @Description("Test Description: Delete team and verify it")
    public void deleteTeamAndVerify()
    {
        apiFlows.deleteTeam();
        verifications.assertTextToText(apiFlows.getTeamProperty("totalCount"),"0");
    }
}
