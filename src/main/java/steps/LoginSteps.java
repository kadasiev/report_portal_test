package steps;

import lombok.extern.slf4j.Slf4j;
import model.User;

@Slf4j
public class LoginSteps extends BaseSteps {

  public void login(User user) {
    loginPage.enterLogin(user.login())
        .enterPassword(user.password())
        .clickLoginButton();
    log.info("User {} Logged in", "\"" + user.login() + "\"");
  }
}
