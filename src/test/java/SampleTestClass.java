import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class SampleTestClass {

    WebDriver driver = null;

    @BeforeTest()
    public void setUp(){
        utils.WebDriverFactory.createInstance("Chrome");
        driver = utils.WebDriverFactory.getDriver();
    }
    @Test
    public void sampleTestMethod() {
        driver.get("https://www.google.com/");
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Artur");
        assert 1 == 2;
    }

    @AfterTest()
    public void tearDown() {
        // Close the browser
        WebDriverFactory.getDriver().quit();
    }
}
