package tests;

import static driver.DriverFactory.closeBrowser;
import static driver.DriverFactory.openBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  @BeforeMethod(groups = {"run"})
  public void setUp() {
    openBrowser();
  }

  @AfterMethod(groups = {"run"})
  public void tearDown() {
    closeBrowser();
  }
}
