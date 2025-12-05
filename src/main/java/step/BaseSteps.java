package step;

import page.LoginPage;
import page.DashboardsPage;
import page.SidebarBlock;

public class BaseSteps {

  protected LoginPage loginPage = new LoginPage();
  protected DashboardsPage dashboardsPage = new DashboardsPage();
  protected SidebarBlock sidebarBlock = new SidebarBlock();
}
