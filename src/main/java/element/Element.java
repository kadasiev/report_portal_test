package element;

import static driver.DriverFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.frameToBeAvailableAndSwitchToIt;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {

  private final By by;
  private static final int TIMEOUT = 60;
  private static final int SHORT_TIMEOUT = 10;

  private Element(By by) {
    this.by = by;
  }

  public static Element xpath(String xpath) {
    return new Element(By.xpath(xpath));
  }

  public WebElement waitForVisibility() {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(visibilityOfElementLocated(by));
  }

  public WebElement waitForVisibilityFor(long seconds) {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds))
        .until(visibilityOfElementLocated(by));
  }

  public void waitForPresence() {
    new WebDriverWait(getDriver(), Duration.ofSeconds(SHORT_TIMEOUT))
        .until(presenceOfElementLocated(by));
  }

  public List<WebElement> waitForVisibilityOfAll() {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(visibilityOfAllElementsLocatedBy(by));
  }

  public void switchToFrame() {
    new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT))
        .until(frameToBeAvailableAndSwitchToIt(by));
  }

  public void click() {
    waitForVisibility().click();
  }

  public void clickFor(long seconds) {
    waitForVisibilityFor(seconds).click();
  }

  public void tryToClickFor(long seconds) {
    try {
      waitForVisibilityFor(seconds).click();
    } catch(TimeoutException ignored) {}
  }

  public void doubleClick() {
    new Actions(getDriver()).doubleClick(waitForVisibility())
        .build().perform();
  }

  public void sendKeys(CharSequence... keys) {
    waitForVisibility().sendKeys(keys);
  }

  public void clear() {
    waitForVisibility().clear();
  }

  public void hoverOver() {
    new Actions(getDriver()).moveToElement(waitForVisibility())
        .build().perform();
  }

  public String getText() {
    return waitForVisibility().getText();
  }

  public WebElement get(int index) {
    return waitForVisibilityOfAll().get(index);
  }

  public List<WebElement> getList() {
    return waitForVisibilityOfAll();
  }

  public boolean isPresent() {
    try {
      waitForPresence();
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public boolean isDisplayed() {
    try {
      return getDriver().findElement(by).isDisplayed();
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean attributeContains(String attribute, String value) {
    return waitForVisibility().getAttribute(attribute).contains(value);
  }
}
