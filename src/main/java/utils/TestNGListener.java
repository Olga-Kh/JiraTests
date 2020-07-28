package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("It happens before each test and after BeforeMethod, thanks to Listener & OnTestStart");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println("The name of the test passed is :" + result.getName());
  }

  @Override
  public void onTestFailure(ITestResult result) {

  }

  @Override
  public void onTestSkipped(ITestResult result) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

  }

  @Override
  public void onStart(ITestContext context) {
    System.out.println("It happens on test suite launch, thanks to Listener & onStart");
  }

  @Override
  public void onFinish(ITestContext context) {
    System.out.println("It happens on test suite finished, thanks to Listener & onFinish");
  }
}