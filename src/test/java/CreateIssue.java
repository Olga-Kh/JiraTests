import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.createIssuePage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class CreateIssue {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  createIssuePage createIssue = null;

  @BeforeMethod
  public void setUp(){
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    createIssue = new createIssuePage(driver);
    homePage = new HomePage(driver);
  }

  @Test
  public void successfullCreateTicket(){

    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    assertTrue(homePage.isUserIconIsPresent());
    createIssue.clickIssueCreate();

    createIssue.isProjectFieldDisplayed();
    createIssue.clickProjectField();
    createIssue.inputProjectField("Webinar (WEBINAR)");
    createIssue.leaveProjectField();

    assertTrue(createIssue.isIssueTypeFieldClickable());
    createIssue.clickIssueType();
    createIssue.inputIssueType("Test");
    createIssue.leaveIssueType();

    assertTrue(createIssue.isSummaryFieldClickable());
    createIssue.inputSummary("Summary");

    assertTrue(createIssue.isReporterFieldClickable());
    createIssue.clearReporterField();
    createIssue.inputReporter("OlgaKhobina");
    createIssue.leaveReporterField();

    createIssue.clickTextTab();
    createIssue.clickDescriptionField();
    createIssue.inputDescription("Some description");

    driver.findElement(By.id("create-issue-submit")).click();
    createIssue.clickSubmitIssue();
    assertTrue(createIssue.isSuccessPopupDisplayed());
  }

  @AfterMethod
  public void tearDown(){
    driver.quit();
  }
}
