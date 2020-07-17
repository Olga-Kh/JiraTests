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

    addComment.isCommentAdded();
    String commentText = driver.findElement(By.xpath("//div[@id='issue_actions_container']//div[last()]//p")).getText();
    assertTrue(commentText.contains("Very important comment"));

    addComment.clickDeleteIcon();
    addComment.isDeleteButtonClickable();
    addComment.clickDeleteButton();

    addComment.isNoCommentsMessageDisplayed();
    String emptyComments = driver.findElement(By.xpath("//div[@class='message-container']")).getText();
    assertTrue(emptyComments.contains("There are no comments yet on this issue."));
  }

/*  @AfterMethod
  public void tearDown(){
    driver.quit();
  }*/
}