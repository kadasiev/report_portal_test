package tests.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static util.DashboardCreator.getDashboard;
import static util.TestDataReader.getValue;

import io.restassured.response.Response;
import model.Dashboard;
import org.json.JSONObject;
import org.testng.annotations.Test;

@Test
public class DashboardTest {

  private static final String CREATE_DASHBOARD_ENDPOINT = "/api/v1/default_personal/dashboard";
  private static final String GET_DASHBOARD_BY_ID_ENDPOINT = "/api/v1/default_personal/dashboard";

  private String dashboardId;

  @Test
  public void verifyThatDashboardIsCreated() {
    Dashboard dashboard = getDashboard();

    Response response = given()
        .auth().oauth2(getValue("apiKey"))
        .contentType("application/json")
        .body(dashboard)
    .when()
        .post(CREATE_DASHBOARD_ENDPOINT);

    dashboardId = response.jsonPath().getString("id");

    assertEquals(response.statusCode(), 201, "Dashboard isn't created!");
  }

  @Test(dependsOnMethods = {"verifyThatDashboardIsCreated"})
  public void verifyThatDashboardWasCreated() {
    given()
        .auth().oauth2(getValue("apiKey"))
        .contentType("application/json")
    .when()
        .get(GET_DASHBOARD_BY_ID_ENDPOINT + dashboardId)
    .then()
        .statusCode(200)
        .log().all();
  }

  @Test
  public void verifyThatDashboardIsNotCreated() {
    Dashboard dashboard = getDashboard();

    JSONObject data = new JSONObject();
    data.put("description", dashboard.description());

    given()
        .auth().oauth2(getValue("apiKey"))
        .contentType("application/json")
        .body(data.toString())
    .when()
        .post(CREATE_DASHBOARD_ENDPOINT)
    .then()
        .statusCode(400)
        .log().all();
  }
}
