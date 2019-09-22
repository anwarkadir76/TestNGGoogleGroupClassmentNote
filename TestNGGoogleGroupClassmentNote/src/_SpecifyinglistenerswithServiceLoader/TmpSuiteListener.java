package _SpecifyinglistenerswithServiceLoader;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.Test;

public class TmpSuiteListener implements ISuiteListener {
	  @Override
	  public void onFinish(ISuite suite) {
	    System.out.println("Finishing");
	  }
	 
	  @Override
	  public void onStart(ISuite suite) {
	    System.out.println("Starting");
	  }
	}
