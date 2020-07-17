import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddCommentPage;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddComment {
  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  CreateIssuePage createIssue = null;
  AddCommentPage addComment = null;

  @BeforeMethod
  public void setUp(){
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    createIssue = new CreateIssuePage(driver);
    homePage = new HomePage(driver);
    addComment = new AddCommentPage(driver);
  }

  @Test
  public void addCommentToTicket() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());;

    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.clickPasswordField();
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    assertTrue(homePage.isUserIconIsPresent());

    addComment.navigateToTicket();
    addComment.clickCommentIssue();

    addComment.isCommentFieldclickable();
    addComment.clickCommentField();
    addComment.inputCommentField("Very important comment");
    addComment.isSubmitCommentClickable();
    addComment.clickSubmitComment();

    //wait.until(presenceOfElementLocated(By.xpath("//div[@id='issue_actions_container']//div[last()]//p"))).isDisplayed();
    addComment.isCommentAdded();
    String commentText = driver.findElement(By.xpath("//div[@id='issue_actions_container']//div[last()]//p")).getText();
    assertTrue(commentText.contains("Very important comment"));

    driver.findElement(By.xpath("//div[@id='issue_actions_container']//div[last()]//div[@class='action-links']//a[last()]")).click();
    wait.until(elementToBeClickable(By.id("comment-delete-submit")));
    driver.findElement(By.id("comment-delete-submit")).click();

    wait.until(presenceOfElementLocated(By.xpath("//div[@class='message-container']"))).isDisplayed();
    String emptyComments = driver.findElement(By.xpath("//div[@class='message-container']")).getText();
    assertTrue(emptyComments.contains("There are no comments yet on this issue."));
  }

/*  @AfterMethod
  public void tearDown(){
    driver.quit();
  }*/
}