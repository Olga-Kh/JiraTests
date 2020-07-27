import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class TestWithParameters {

  WebDriver driver = null;

  @Parameters({"browserName"})
  @BeforeMethod
  public void setUp(String browserName) {
    WebDriverFactory.createInstance(browserName);
    driver = WebDriverFactory.getDriver();
    System.out.println("Browser name is " + browserName);
  }


  @Test
  public static void testWithParametersAnnotation() {

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
