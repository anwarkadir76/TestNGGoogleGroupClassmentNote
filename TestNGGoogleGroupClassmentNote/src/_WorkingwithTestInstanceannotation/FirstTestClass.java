package _WorkingwithTestInstanceannotation;

import org.testng.annotations.Test;

public class FirstTestClass {
    @Test (dataProvider="data-provider", dataProviderClass=LocalDataProvider.class)
    public void testmethod(int number) {
        System.err.println("Value = " + number);
    }
}