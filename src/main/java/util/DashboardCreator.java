package util;

import static util.RandomStringGenerator.generateRandomString;

import model.Dashboard;

public class DashboardCreator {

  public static Dashboard getDashboard() {
    return new Dashboard(generateRandomString(10), generateRandomString(10));
  }
}
