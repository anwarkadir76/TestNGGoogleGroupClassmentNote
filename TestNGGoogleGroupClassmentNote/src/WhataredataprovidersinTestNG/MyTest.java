package WhataredataprovidersinTestNG;

import org.testng.annotations.Test;

public class MyTest {
	  @Test(dataProvider = "create", dataProviderClass = StaticProvider.class)
	  public void test(Integer n) {
	    // ...
	  }
	}
