package tests.api;

import static util.TestDataReader.getValue;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

  @BeforeSuite
  public static void setUp() {
    RestAssured.baseURI = getValue("baseURL");
  }
}
