package WhataredataprovidersinTestNG;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GreedyDataProviderExample {
    @DataProvider(name = "data-source")
    public Object[][] allDataInOneShot() {
        return new Object[][] { { "Java" }, { "TestNG" }, { "JUnit" } };
    }
 
    @Test(dataProvider = "data-source")
    public void myTestMethod(String info) { //Lets take a look at what is the Greedy Data Provider in TestNG.
        Reporter.log("Data provided was :" + info, true);
    }
}