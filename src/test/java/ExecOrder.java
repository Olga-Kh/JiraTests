import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecOrder {
  @BeforeMethod
  public void beforeMethod() {
    System.out.println("It happens before each test and before Listener, thanks to BeforeMethod");
  }

  @Test
  public void successfulTest() {
    assert 1==1;
    System.out.println("Passed Test" + "\n");
  }

  @Test
  public void unsuccessfulTest() {
    assert 1==0;
    System.out.println("Not passed test");
  }

  @AfterMethod
  public void afterMethod() {
    System.out.println("It happens after each test, thanks to AfterMethod");
  }
}
