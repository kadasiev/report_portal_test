package api.dashboard;

import static api.DashboardApi.createDashboard;
import static api.DashboardApi.deleteDashboard;
import static api.DashboardApi.getDashboard;
import static factory.DashboardFactory.newDashboard;

import io.restassured.response.Response;
import model.Dashboard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class CreateDashboardPositiveTest {

  private static final String PROJECT_NAME = "default_personal";

  private Dashboard dashboard;
  private int dashboardId;

  @BeforeMethod
  public void setUp() {
    dashboard = newDashboard();
  }

  @AfterMethod
  public void tearDown() {
    try {
      deleteDashboard(PROJECT_NAME, dashboardId);
    } catch (Exception ignored) {
    }
  }

  @Test
  public void shouldCreateDashboardWhenValidPayloadProvided() {
    Response response = createDashboard(PROJECT_NAME, dashboard);
    response.then()
        .statusCode(201);

    dashboardId = response.jsonPath().getInt("id");

    getDashboard(PROJECT_NAME, dashboardId).then()
        .statusCode(200);
  }
}
