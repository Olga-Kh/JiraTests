import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;


import static org.testng.Assert.assertTrue;


public class ViewJiraTicket {
  WebDriver driver = null;

  @BeforeMethod
  public void setUp(){
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
  }

  @Test
  public void successfulViewTicket(){
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    driver.findElement(By.id("login-form-username")).sendKeys("OlgaKhobina");
    driver.findElement(By.id("login-form-password")).sendKeys("OlgaKhobina");
    driver.findElement(By.id("login")).click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertTrue(driver.findElement(By.id("header-details-user-fullname")).isDisplayed());

    driver.findElement(By.id("find_link")).click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.xpath("//div[@id='issues_history_main']//ul/li[1]")).click();
    assertTrue(driver.findElement(By.id("type-val")).isDisplayed());
    String ticketNumber = driver.findElement(By.id("key-val")).getText();
    assertTrue(driver.getCurrentUrl().contains(ticketNumber));
  }

  @AfterMethod
  public void tearDown(){
    driver.quit();
  }
}
