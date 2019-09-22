package _SharingparametersamongdifferentTestNGsuites;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class ReadParameters {
    @Test
    @Parameters({ "username" })
    public void f(String userName) {
        Assert.assertTrue(userName.equals("testng"));
        System.err.println("User name is " + userName);
    }
}