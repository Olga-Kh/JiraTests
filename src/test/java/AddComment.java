import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddComment {
  WebDriver driver = null;


  @BeforeMethod
  public void setUp(){
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
  }

  @Test
  public void addCommentToTicket(){

    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    driver.findElement(By.id("login-form-username")).sendKeys("OlgaKhobina");
    driver.findElement(By.id("login-form-password")).sendKeys("OlgaKhobina");
    driver.findElement(By.id("login")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    assertEquals(wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed(), true);

    driver.get("https://jira.hillel.it/browse/WEBINAR-12197");
    driver.findElement(By.id("comment-issue")).click();

    wait.until(elementToBeClickable(By.id("comment")));
    driver.findElement(By.id("comment")).sendKeys("Very important comment");
    driver.findElement(By.id("issue-comment-add-submit")).click();

    wait.until(presenceOfElementLocated(By.xpath("//div[@id='issue_actions_container']//div[last()]//p"))).isDisplayed();
    String commentText = driver.findElement(By.xpath("//div[@id='issue_actions_container']//div[last()]//p")).getText();
    assertTrue(commentText.contains("Very important comment"));

    driver.findElement(By.xpath("//div[@id='issue_actions_container']//div[last()]//div[@class='action-links']//a[last()]")).click();
    wait.until(elementToBeClickable(By.id("comment-delete-submit")));
    driver.findElement(By.id("comment-delete-submit")).click();

    wait.until(presenceOfElementLocated(By.xpath("//div[@class='message-container']"))).isDisplayed();
    String emptyComments = driver.findElement(By.xpath("//div[@class='message-container']")).getText();
    assertTrue(emptyComments.contains("There are no comments yet on this issue."));
  }

  @AfterMethod
  public void tearDown(){
    driver.quit();
  }
}