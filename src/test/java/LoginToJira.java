import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void successfullLoginTest() {
      loginPage.navigateTo();
      loginPage.enterUserName("OlgaKhobina");
      loginPage.enterPassword("OlgaKhobina");
      loginPage.clickLoginButton();
      assertTrue(homePage.userIconIsPresent());
    }

    @AfterMethod
    public void tearDown() {
      driver.quit();
    }
  }

