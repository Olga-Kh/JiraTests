import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ViewIssuePage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class ViewIssue {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  ViewIssuePage viewIssue = null;

  @BeforeMethod
  public void setUp() {
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    viewIssue = new ViewIssuePage(driver);
  }

  @Test
  public void successfulViewTicket() {
    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    assertTrue(homePage.isUserIconIsPresent());

    viewIssue.openIssuesDropdown();
    viewIssue.isFirstIssueDisplayed();
    viewIssue.clickFirstIssue();
    viewIssue.isIssueTypeDisplayed();
    viewIssue.isTicketNumberInUrl();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}