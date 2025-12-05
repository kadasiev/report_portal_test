package step;

import static driver.Driver.waitFor;

import lombok.extern.slf4j.Slf4j;
import model.Widget;

@Slf4j
public class DashboardsSteps extends BaseSteps {

  public void openDashboard(String dashboardName) {
    dashboardsPage.waitUntilSignedInSuccessfullyNotificationDisappears()
        .openDashboard(dashboardName);

    log.info("Dashboard {} opened", "\"" + dashboardName + "\"");

  }

  public void addWidget(Widget widget) {
    dashboardsPage.clickAddNewWidgetButton()
        .chooseWidgetType(widget.widgetType())
        .clickNextStep()
        .chooseFirstFilter()
        .clickNextStep()
        .enterWidgetName(widget.widgetName())
        .clickAddButton();

    log.info("Widget {} created", "\"" + widget.widgetName() + "\"");
  }

  public boolean isWidgetDisplayed(Widget widget) {
    waitFor(3);
    return dashboardsPage.isWidgetDisplayed(widget.widgetName());
  }

  public void deleteWidget(Widget widget) {
    dashboardsPage.deleteWidget(widget.widgetName())
        .confirmDelete();

    log.info("Widget {} deleted", "\"" + widget.widgetName() + "\"");
  }
}
