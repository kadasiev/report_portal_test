package tests.api;

import static io.restassured.RestAssured.given;
import static util.DashboardCreator.getDashboard;
import static util.TestDataReader.getValue;

import model.Dashboard;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class DashboardTest {

  public static final String CREATE_DASHBOARD_ENDPOINT = "https://demo.reportportal.io/api/v1/default_personal/dashboard";

  @Test
  public void createDashboard() {
    Dashboard dashboard = getDashboard();

    given()
        .contentType("application/json")
        .header("Authorization", getValue("authorization"))
        .body(dashboard)
    .when()
        .post(CREATE_DASHBOARD_ENDPOINT)
    .then()
        .statusCode(201)
        .log().all();
  }

  @Test
  public void createDashboardWithWrongParameters() {
    Dashboard dashboard = getDashboard();

    JSONObject data = new JSONObject();
    data.put("description", dashboard.description());

    given()
        .contentType("application/json")
        .header("Authorization", getValue("authorization"))
        .body(data.toString())
    .when()
        .post(CREATE_DASHBOARD_ENDPOINT)
    .then()
        .statusCode(400)
        .log().all();
  }
}
