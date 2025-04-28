package tests.ui;

import static driver.Driver.openPage;
import static org.testng.Assert.assertTrue;
import static util.TestDataReader.getValue;
import static util.UserCreator.getUser;
import static util.WidgetCreator.getWidget;

import model.Widget;
import org.testng.annotations.Test;

public class WidgetsTest extends BaseTest {

  private static final String DASHBOARD_NAME = "TestName2734";
  private static final String SECTION_NAME = "Dashboards";
  private static final String WIDGET_TYPE = "Launch statistics chart";

  @Test()
  public void verifyThatWidgetIsDisplayed() {
    Widget widget = getWidget(WIDGET_TYPE);
    openPage(getValue("baseURL"));
    loginSteps.login(getUser());
    navigationSteps.openSection(SECTION_NAME);
    dashboardsSteps.openDashboard(DASHBOARD_NAME);
    dashboardsSteps.addWidget(widget);
    boolean isWidgetDisplayed = dashboardsSteps.isWidgetDisplayed(widget);
    dashboardsSteps.deleteWidget(widget);

    assertTrue(isWidgetDisplayed);
  }
}
