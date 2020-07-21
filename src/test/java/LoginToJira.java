import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginToJira {

    WebDriver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;

    @BeforeMethod
    public void setUp() {
      WebDriverFactory.createInstance("Chrome");
      driver = WebDriverFactory.getDriver();
      loginPage = new LoginPage(driver);
      homePage = new HomePage(driver);
    }

    @DataProvider(name = "Logins")
    public Object[][] createData() {
      return new Object[][] {
              { "OlgaKhobina", "wrongPassword" },
              { "wrongUserName", "OlgaKhobina" },
      };
    }

  @Test(dataProvider = "Logins")
  public void unsuccessfulLoginTest(String name, String password) throws InterruptedException {
    loginPage.navigateTo();
    loginPage.enterUserName(name);
    loginPage.enterPassword(password);
    loginPage.clickLoginButton();
    assertTrue(loginPage.isErrorMessageDisplayed());
  }

    @Test
    public void successfullLoginTest() {
      loginPage.navigateTo();
      loginPage.enterUserName("OlgaKhobina");
      loginPage.enterPassword("OlgaKhobina");
      loginPage.clickLoginButton();
      assertTrue(homePage.isUserIconIsPresent());
    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }
  }

