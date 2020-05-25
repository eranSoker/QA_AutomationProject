package WorkFlows;

import Extensions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps
{
    @Step("Get Team Property")
    public static String getTeamProperty (String jPath)
    {
        Response response = apiActions.get("/api/teams/search");
        return apiActions.extractFromJSON(response, jPath);
    }

    @Step("Create New Team In Grafana")
    public static void postTeam (String name, String email)
    {
        requestParams.put("name", name);
        requestParams.put("email", email);
        apiActions.post(requestParams,"/api/teams");
    }

    @Step("Update Team properties In Grafana")
    public static void updateTeam (String name, String email)
    {
        requestParams.put("name", name);
        requestParams.put("email", email);
        String teamId = getTeamProperty("teams[0].id");
        apiActions.put(requestParams,"/api/teams/" + teamId);
    }

    @Step("Delete Team In Grafana")
    public static void deleteTeam ()
    {
        String teamId = getTeamProperty("teams[0].id");
        apiActions.delete(teamId);
    }
}
