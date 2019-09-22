package _ThreadAffinityinTestNG;

import org.testng.annotations.Test;

public class TestClass {

	  @Test
	  public void a() {
	    System.err.println("Running a() on Thread " + Thread.currentThread().getId());
	  }

	  @Test
	  public void b() {
	    System.err.println("Running b() on Thread " + Thread.currentThread().getId());
	  }

	  @Test(dependsOnMethods = "a")
	  public void c() {
	    System.err.println("Running c() on Thread " + Thread.currentThread().getId());
	  }
	}