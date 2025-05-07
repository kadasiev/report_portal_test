package driver;

import static driver.DriverFactory.getDriver;

public class Driver {

  public static void waitFor(long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException ignored) {}
  }

  public static void openPage(String url) {
    getDriver().navigate().to(url);
  }
}
