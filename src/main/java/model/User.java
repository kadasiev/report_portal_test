package model;

public record User(String login, String password) {

  @Override
  public String toString() {
    return "User (" +
        "login = '" + login + '\'' +
        ", password= '" + password + '\'' +
        ')';
  }
}
