package util;

import static util.RandomStringGenerator.generateRandomString;

import model.Widget;

public class WidgetCreator {

  public static Widget getWidget(String widgetType) {
    return new Widget(widgetType, generateRandomString(10));
  }
}
