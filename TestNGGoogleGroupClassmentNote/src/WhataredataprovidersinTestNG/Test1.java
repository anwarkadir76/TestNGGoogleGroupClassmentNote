package WhataredataprovidersinTestNG;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test1 {
	@DataProvider(name = "test1")
	public Iterator<Object[]> createData1() {
	  return new MyIterator(DATA);
	}

	
	@DataProvider(name = "test1")
	public Iterator<MyCustomData> createData1() {
	  return Arrays.asList(new MyCustomData()).iterator();
	}

	@DataProvider(name = "test1")
	public Iterator<Stream> createData() {
	  return Arrays.asList(Stream.of("a", "b", "c")).iterator();
	}
	@DataProvider(name = "dp")
	public Object[][] createData(Method m) {
	  System.out.println(m.getName());  // print test method name
	  return new Object[][] { new Object[] { "Cedric" }};
	}
	 
	@Test(dataProvider = "dp")
	public void test1(String s) {
	}
	 
	@Test(dataProvider = "dp")
	public void test2(String s) {
	}

	@DataProvider(parallel = true);
	// ...

}
