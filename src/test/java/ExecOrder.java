import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecOrder {
  @BeforeMethod
  public void beforeMethod() {
    System.out.println("Test#1! It happens before each test and before Listener, thanks to BeforeMethod");
  }

  @Test
  public void successfulTest() {
    assert 1==1;
    System.out.println("First Test");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("It happens after each test, thanks to AfterMethod");
  }
}