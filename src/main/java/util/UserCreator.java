package util;

import static util.TestDataReader.getValue;

import model.User;

public class UserCreator {

  public static User getUser() {
    return new User(getValue("login"),
        getValue("password"));
  }
}
