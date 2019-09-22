package WhataredataprovidersinTestNG;

import java.util.Iterator;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LazyDataProviderExample { //Lets take a look at what is the Lazy Data Provider in TestNG.
    @Test(dataProvider = "data-source")
    public void myTestMethod(String info) {
        Reporter.log("Data provided was :" + info, true);
    }
 
    @DataProvider(name = "data-source")
    public Iterator<Object[]> dataOneByOne() {
        return new MyData();
 
    }
 
    private static class MyData implements Iterator<Object[]> {
        private String[] data = new String[] { "Java", "TestNG", "JUnit" };
        private int index = 0;
 
        @Override
        public boolean hasNext() {
            return (index <= (data.length - 1));
        }
 
        @Override
        public Object[] next() {
            return new Object[] { data[index++] };
        }
 
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Removal of items is not supported");
        }
    }
 
}