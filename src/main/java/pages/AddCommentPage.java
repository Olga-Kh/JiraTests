package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class AddCommentPage {

  private WebDriver driver = null;
  private WebDriverWait wait = null;
  private By commentIssue = By.id("comment-issue");
  private By comment = By.id("comment");
  private By submitComment = By.id("issue-comment-add-submit");
  private By lastComment = By.xpath("//div[@id='issue_actions_container']//div[last()]//p");

  public AddCommentPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());
  }

  public void navigateToTicket() {
    driver.get("https://jira.hillel.it/browse/WEBINAR-12197");
  }

  public void clickCommentIssue() {
    driver.findElement(commentIssue).click();
  }

  public boolean isCommentFieldclickable() {
    return wait.until(elementToBeClickable(comment)).isDisplayed();
  }

  public void clickCommentField() {
    driver.findElement(comment).click();
  }

  public void inputCommentField(String commentText) {
    driver.findElement(comment).sendKeys(commentText);
  }

  public boolean isSubmitCommentClickable() {
    return wait.until(elementToBeClickable(submitComment)).isDisplayed();
  }

  public void clickSubmitComment() {
    driver.findElement(submitComment).click();
  }

  public boolean isCommentAdded() {
    return wait.until(presenceOfElementLocated(lastComment)).isDisplayed();
  }

/*  public boolean commentTextCompare(lastCommentContent) {
    String lastCommentText = driver.findElement(lastComment).getText();
    return lastCommentText.contains()
  }*/


}
