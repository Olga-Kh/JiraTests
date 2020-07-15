import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateIssuePage;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateIssue {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  CreateIssuePage createIssue = null;

  @BeforeMethod
  public void setUp(){
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    createIssue = new CreateIssuePage(driver);
    homePage = new HomePage(driver);
  }

  @Test
  public void successfullCreateTicket(){

    loginPage.navigateTo();
    loginPage.enterUserName("OlgaKhobina");
    loginPage.enterPassword("OlgaKhobina");
    loginPage.clickLoginButton();
    assertTrue(homePage.userIconIsPresent());

  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    /*  boolean elementIsPresent = wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();
    assertEquals(elementIsPresent, true);*/

    //driver.findElement(By.id("create_link")).click();
    createIssue.issueCreateClick();



    wait.until(presenceOfElementLocated(By.id("project-field"))).isDisplayed();
    driver.findElement(By.id("project-field")).clear();
    driver.findElement(By.id("project-field")).sendKeys("Webinar (WEBINAR)");
    driver.findElement(By.id("project-field")).sendKeys(Keys.TAB);


    threadSleep(1000);

    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("issuetype-field")));
    driver.findElement(By.id("issuetype-field")).click();
    driver.findElement(By.id("issuetype-field")).sendKeys("Test");
    driver.findElement(By.id("issuetype-field")).sendKeys(Keys.TAB);

    //threadSleep(1000);


    wait.until(presenceOfElementLocated(By.id("summary"))).isDisplayed();
    driver.findElement(By.id("summary")).sendKeys("...");

    driver.findElement(By.id("reporter-field")).clear();
    driver.findElement(By.id("reporter-field")).sendKeys("OlgaKhobina");

    driver.findElement(By.xpath("(//div[@id='description-wiki-edit']//a[contains(text(),'Text')])")).click();
    driver.findElement(By.id("description")).click();
    driver.findElement(By.id("description")).sendKeys("Test description");

    driver.findElement(By.id("create-issue-submit")).click();

    wait.until(presenceOfElementLocated(By.className("aui-message-success"))).isDisplayed();
  }

  private void threadSleep(int ms)
  {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
/*  @AfterMethod
  public void tearDown(){
    driver.quit();
  }*/
}
