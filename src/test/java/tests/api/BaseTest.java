package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  @BeforeSuite
  public static void setUp() {
    RestAssured.baseURI = "https://demo.reportportal.io";
  }
}
