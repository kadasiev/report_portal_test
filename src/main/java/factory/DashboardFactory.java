package factory;

import static util.RandomStringGenerator.generateRandomString;

import model.Dashboard;

public class DashboardFactory {

  public static Dashboard newDashboard() {
    return new Dashboard(generateRandomString(10), generateRandomString(10));
  }
}
