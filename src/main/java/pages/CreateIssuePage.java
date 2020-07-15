package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateIssuePage {

  private WebDriver driver = null;
  private By createButton = By.id("create_link");

  public CreateIssuePage(WebDriver driver) {
    this.driver = driver;
  }

  public void issueCreateClick() {
    driver.findElement(createButton).click();
  }

}
