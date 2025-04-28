package steps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NavigationSteps extends BaseSteps {

  public void openSection(String sectionName) {
    switch (sectionName) {
      case "Dashboards" -> sidebarBlock.openSection("Dashboards");
      default -> throw new IllegalArgumentException("Unknown section: " + sectionName);
    }
    log.info("Выполнен переход в раздел: {}", "\"" + sectionName + "\"");
  }
}
