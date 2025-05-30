package element;

import static driver.DriverFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.time.Duration;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class Element {

  private final By by;
  private static final int TIMEOUT = 20;

  private Element(By by) {
    this.by = by;
  }

  public static Element xpath(String xpath) {
    return new Element(By.xpath(xpath));
  }

  public WebElement waitForVisibility() {
    log.info("Waiting for visibility of element located by: {}", "\"" + by.toString() + "\"");

    WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(visibilityOfElementLocated(by));

    log.info("Element is now visible: {}", "\"" + by.toString() + "\"");
    return element;
  }

  public void waitForInvisibility() {
    log.info("Waiting for invisibility of element located by: {}", "\"" + by.toString() + "\"");

    new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(invisibilityOfElementLocated(by));

    log.info("Element is now invisible: {}", "\"" + by.toString() + "\"");
  }

  public void click() {
    WebElement element = waitForVisibility();
    element.click();

    log.info("Clicked on element: {}", "\"" + by.toString() + "\"");
  }

  public void sendKeys(CharSequence... keys) {
    WebElement element = waitForVisibility();
    element.sendKeys(keys);

    log.info("The value {} was entered into field: {}", Arrays.toString(keys), "\"" + by.toString() + "\"");
  }

  public void clear() {
    WebElement element = waitForVisibility();
    element.clear();

    log.info("The value was deleted from the field: {}", "\"" + by.toString() + "\"");
  }

  public void hoverOver() {
    new Actions(getDriver()).moveToElement(waitForVisibility())
        .build().perform();
  }

  public boolean isDisplayed() {
    try {
      return getDriver().findElement(by).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
