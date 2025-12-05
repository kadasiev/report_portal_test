package page;

import static element.Element.xpath;

public class SidebarBlock {

  private final static String SECTION_PATTERN = "//*[contains(@class, 'sidebarButton') and text() = '%s']/parent::span";

  public void openSection(String sectionName) {
    xpath(String.format(SECTION_PATTERN, sectionName)).click();
  }
}
