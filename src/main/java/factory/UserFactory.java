package factory;

import static util.TestDataReader.getValue;

import model.User;

public class UserFactory {

  public static User newUser() {
    return new User(getValue("login"),
        getValue("password"));
  }
}
