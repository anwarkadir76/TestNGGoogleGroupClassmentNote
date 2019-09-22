package WhataredataprovidersinTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StaticProvider {
	  @DataProvider(name = "create")
	  public static Object[][] createData() {
	    return new Object[][] {
	      new Object[] { new Integer(42) }
	    };
	  }
	}
	 
	

	