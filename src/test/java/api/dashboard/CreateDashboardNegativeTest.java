package api.dashboard;

import static api.DashboardApi.createDashboard;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateDashboardNegativeTest {

  private static final String PROJECT_NAME = "default_personal";

  @Test
  public void shouldNotCreateDashboardWhenInvalidPayloadProvided() {
    JSONObject dashboard = new JSONObject();
    dashboard.put("description", "Dashboard description");

    createDashboard(PROJECT_NAME, dashboard).then()
        .statusCode(400);
  }
}



