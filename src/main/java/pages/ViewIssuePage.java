package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ViewIssuePage {
  private WebDriver driver = null;
  private WebDriverWait wait = null;
  private By issuesDropdown = By.id("find_link");
  private By firstIssueInDropdown = By.xpath("//div[@id='issues_history_main']//ul/li[1]");
  //private By issueType = By.id("type-val");
  private By ticketNumber = By.id("key-val1");


  public ViewIssuePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
  }

  public void openIssuesDropdown() {
    driver.findElement(issuesDropdown).click();
  }

  public boolean isFirstIssueDisplayed() {
    return wait.until(presenceOfElementLocated(firstIssueInDropdown)).isDisplayed();
  }

  public void clickFirstIssue() {
    driver.findElement(firstIssueInDropdown).click();
  }

  public ExpectedCondition<WebElement> isIssueTypeDisplayed() {
    return presenceOfElementLocated(firstIssueInDropdown);
  }

  public boolean isTicketNumberInUrl() {
    String number = driver.findElement(ticketNumber).getText();
    return driver.getCurrentUrl().contains(number);
  }
}
