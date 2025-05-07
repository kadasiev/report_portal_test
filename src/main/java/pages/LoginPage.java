package pages;

import static element.Element.xpath;

import element.Element;

public class LoginPage {

  private final Element loginField = xpath("//input[@type = 'text']");
  private final Element passwordField = xpath("//input[@type = 'password']");
  private final Element loginButton = xpath("//*[@type = 'submit']");

  public LoginPage enterLogin(String login) {
    loginField.clear();
    loginField.sendKeys(login);
    return this;
  }

  public LoginPage enterPassword(String password) {
    passwordField.clear();
    passwordField.sendKeys(password);
    return this;
  }

  public void clickLoginButton() {
    loginButton.click();
  }
}
