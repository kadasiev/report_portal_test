package factory;

import static util.RandomStringGenerator.generateRandomString;

import model.Widget;

public class WidgetFactory {

  public static Widget newWidget(String widgetType) {
    return new Widget(widgetType, generateRandomString(10));
  }
}
