import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
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

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3).getSeconds());
    assertEquals(wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed(), true);

    driver.findElement(By.id("find_link")).click();

    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3).getSeconds());
    assertEquals(wait1.until(presenceOfElementLocated(By.xpath("//div[@id='issues_history_main']//ul/li[1]"))).isDisplayed(), true);

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