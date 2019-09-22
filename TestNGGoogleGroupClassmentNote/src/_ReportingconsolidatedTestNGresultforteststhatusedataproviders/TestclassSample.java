package _ReportingconsolidatedTestNGresultforteststhatusedataproviders;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(IListen.class)
public class TestclassSample {

  @NeedConsolidatedResults
  @Test(dataProvider = "dp")
  public void passingTestMethod(int a) {}

  @NeedConsolidatedResults
  @Test(dataProvider = "dp")
  public void failingTestMethod(int a) {
    if (a == 2) {
      Assert.fail();
    }
  }

  @Test
  public void anotherTestMethod() {}

  @DataProvider(name = "dp")
  public Object[][] getData() {
    return new Object[][] {{1}, {2}, {3}};
  }
}