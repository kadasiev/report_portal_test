package tests.ui;

import static driver.DriverFactory.closeBrowser;
import static driver.DriverFactory.openBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.DashboardsSteps;
import steps.LoginSteps;
import steps.NavigationSteps;

public class BaseTest {

  protected LoginSteps loginSteps = new LoginSteps();
  protected DashboardsSteps dashboardsSteps = new DashboardsSteps();
  protected NavigationSteps navigationSteps = new NavigationSteps();

  @BeforeMethod(groups = {"run"})
  public void setUp() {
    openBrowser();
  }

  @AfterMethod(groups = {"run"})
  public void tearDown() {
    closeBrowser();
  }
}
