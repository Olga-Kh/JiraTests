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
  private By deleteIcon = By.xpath("//div[@id='issue_actions_container']//div[last()]//div[@class='action-links']//a[last()]");
  private By deleteButton = By.id("comment-delete-submit");
  private By noCommentsMessage = By.xpath("//div[@class='message-container']");


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

  public void isCommentFieldclickable() {
    wait.until(elementToBeClickable(comment)).isDisplayed();
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

  public boolean commentContainsText(String text) {
    String lastCommentText = driver.findElement(lastComment).getText();
    return lastCommentText.contains(text);
  }

  public void clickDeleteIcon () {
    driver.findElement(deleteIcon).click();
  }

  public boolean isDeleteButtonClickable() {
    return wait.until(elementToBeClickable(deleteButton)).isDisplayed();
  }

  public void clickDeleteButton () {
    driver.findElement(deleteButton).click();
  }

  public boolean isNoCommentsMessageDisplayed() {
    return wait.until(presenceOfElementLocated(noCommentsMessage)).isDisplayed();
  }

  public boolean isNoCommentsTextDisplayed(String text) {
    String emptyComments = driver.findElement(noCommentsMessage).getText();
    return emptyComments.contains(text);
  }
}