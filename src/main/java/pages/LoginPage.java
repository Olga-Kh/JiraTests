package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class LoginPage {

  private WebDriver driver = null;
  private WebDriverWait wait = null;
  private By userNameInput = By.id("login-form-username");
  private By userPassInput = By.id("login-form-password");
  private By loginButton = By.id("login");
  private By errorMessage = By.id("usernameerror");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());
  }

  public void enterUserName(String name) {
    driver.findElement(userNameInput).sendKeys(name);
  }

  public void enterPassword(String password) {
    driver.findElement(userPassInput).sendKeys(password);
  }

  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }

  public void clickPasswordField() {
    driver.findElement(userPassInput).click();
  }

  public void navigateTo() {
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
  }

  public boolean isErrorMessageDisplayed() {
    return wait.until(presenceOfElementLocated(errorMessage)).isDisplayed();
  }
}

