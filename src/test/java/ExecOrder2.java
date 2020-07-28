import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecOrder2 {
  @BeforeMethod
  public void beforeMethod() {
    System.out.println("Test#2! It happens before each test and before Listener, thanks to BeforeMethod");
  }

  @Test
  public void secondSuccessfulTest() {
    assert 1!=0;
    System.out.println("Second test");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("It happens after each test, thanks to AfterMethod");
  }
}
