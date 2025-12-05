package ui.widget;

import static driver.Driver.openPage;
import static org.testng.Assert.assertTrue;
import static util.TestDataReader.getValue;
import static factory.UserFactory.newUser;
import static factory.WidgetFactory.newWidget;

import model.Widget;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.BaseTest;

public class AddWidgetTest extends BaseTest {

  private static final String DASHBOARD_NAME = "TestName2734";
  private static final String SECTION_NAME = "Dashboards";
  private static final String WIDGET_TYPE = "Launch statistics chart";
  Widget widget;

  @BeforeMethod
  public void setUp() {
    widget = newWidget(WIDGET_TYPE);
    openPage(getValue("baseURL"));
    loginSteps.login(newUser());
  }

  @AfterMethod
  public void tearDown() {
    try {
      dashboardsSteps.deleteWidget(widget);
    } catch (Exception ignored) {
    }
  }

  @Test
  public void shouldDisplayWidgetWhenAddedToDashboard() {
    navigationSteps.openSection(SECTION_NAME);
    dashboardsSteps.openDashboard(DASHBOARD_NAME);
    dashboardsSteps.addWidget(widget);

    assertTrue(dashboardsSteps.isWidgetDisplayed(widget),
        "Widget isn't displayed!");
  }
}
