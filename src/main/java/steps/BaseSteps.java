package steps;

import pages.LoginPage;
import pages.DashboardsPage;
import pages.SidebarBlock;

public class BaseSteps {

  protected LoginPage loginPage = new LoginPage();
  protected DashboardsPage dashboardsPage = new DashboardsPage();
  protected SidebarBlock sidebarBlock = new SidebarBlock();
}
