package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class createIssuePage {

  private WebDriver driver = null;
  private WebDriverWait wait = null;
  private By createButton = By.id("create_link");
  private By projectField = By.id("project-field");
  private By issueTypeField = By.id("issuetype-field");
  private By summaryInputField = By.id("summary");
  private By reporterField = By.id("reporter-field");
  private By textTab = By.xpath("(//div[@id='description-wiki-edit']//a[contains(text(),'Text')])");
  private By descriptionField = By.id("description");
  private By submitIssue = By.id("create-issue-submit");
  private By successPopup = By.className("aui-message-success");


  public createIssuePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20).getSeconds());
  }

  public void clickIssueCreate() {
    driver.findElement(createButton).click();
  }

  public boolean isProjectFieldDisplayed() {
    return wait.until(presenceOfElementLocated(projectField)).isDisplayed();
  }

  public void clickProjectField() {
    driver.findElement(projectField).click();
  }

  public void inputProjectField(String project) {
    driver.findElement(projectField).sendKeys(project);
  }

  public void leaveProjectField() {
    driver.findElement(projectField).sendKeys(Keys.TAB);
  }

  public boolean isIssueTypeFieldClickable() {
    return wait.until(elementToBeClickable(issueTypeField)).isDisplayed();
  }

  public void clickIssueType() {
    driver.findElement(issueTypeField).click();
  }

  public void inputIssueType(String issue) {
    driver.findElement(issueTypeField).sendKeys(issue);
  }

  public void leaveIssueType() {
    driver.findElement(issueTypeField).sendKeys(Keys.TAB);
  }

  public boolean isSummaryFieldClickable() {
    return wait.until(elementToBeClickable(summaryInputField)).isDisplayed();
  }

  public void inputSummary(String summary) {
    driver.findElement(summaryInputField).sendKeys(summary);
  }

  public boolean isReporterFieldClickable() {
    return wait.until(elementToBeClickable(reporterField)).isDisplayed();
  }

  public void clearReporterField() {
    driver.findElement(reporterField).clear();
  }

  public void inputReporter(String reporterName) {
    driver.findElement(reporterField).sendKeys(reporterName);
  }

  public void leaveReporterField() {
    driver.findElement(reporterField).sendKeys(Keys.TAB);
  }

  public void clickTextTab() {
    driver.findElement(textTab).click();
  }

  public void clickDescriptionField() {
    driver.findElement(textTab).click();
  }

  public void inputDescription(String descrText) {
    driver.findElement(descriptionField).sendKeys(descrText);
  }

  public void clickSubmitIssue() {
    driver.findElement(submitIssue).click();
  }

  public boolean isSuccessPopupDisplayed() {
    return wait.until(presenceOfElementLocated(successPopup)).isDisplayed();
  }
}
