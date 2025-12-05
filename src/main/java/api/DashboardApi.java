package api;

import static io.restassured.RestAssured.given;
import static util.TestDataReader.getValue;

import io.restassured.response.Response;
import model.Dashboard;

public class DashboardApi extends BaseApi {

  public static Response createDashboard(Dashboard dashboard, String projectName) {
    return given()
        .auth().oauth2(getValue("apiKey"))
        .pathParams("projectName", projectName)
        .contentType("application/json")
        .body(dashboard)
    .when()
        .post("/api/v1/{projectName}/dashboard");
  }

  public static Response getDashboard(String projectName, int dashboardId) {
    return given()
        .auth().oauth2(getValue("apiKey"))
        .pathParams("projectName", projectName)
        .pathParams("dashboardId", dashboardId)
        .contentType("application/json")
    .when()
        .get("/api/v1/{projectName}/dashboard/{dashboardId}");
  }

  public static Response deleteDashboard(String projectName, int dashboardId) {
    return given()
        .auth().oauth2(getValue("apiKey"))
        .pathParams("projectName", projectName)
        .pathParams("dashboardId", dashboardId)
        .contentType("application/json")
    .when()
        .delete("/api/v1/{projectName}/dashboard/{dashboardId}");
  }
}
