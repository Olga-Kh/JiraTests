package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {

  WebDriver driver = null;
  WebDriverWait wait = null;
  private By userPic = By.id("header-details-user-fullname");

  public HomePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
  }

  public boolean isUserIconIsPresent() {
    return wait.until(presenceOfElementLocated(userPic)).isDisplayed();
  }

}
