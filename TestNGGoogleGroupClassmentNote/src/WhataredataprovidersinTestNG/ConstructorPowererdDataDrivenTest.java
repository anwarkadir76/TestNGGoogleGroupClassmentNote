package WhataredataprovidersinTestNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ConstructorPowererdDataDrivenTest {
    private int age;
    private String name;
 
    @Factory(dataProvider = "get-data")
    public ConstructorPowererdDataDrivenTest(String name, int age) { //The constructor acting as the entry point for data driven tests
        this.name = name;
        this.age = age;
    }
 
    @Test
    public void testValidName() {
        Assert.assertTrue(name != null && !name.trim().isEmpty());
    }
 
    @Test
    public void testValidAge() {
        Assert.assertTrue(age > 0);
    }
 
    @DataProvider(name = "get-data")
    public static Object[][] getData() {
        return new Object[][] { { "John", 10 }, { "Peter", 20 } };
    }
}