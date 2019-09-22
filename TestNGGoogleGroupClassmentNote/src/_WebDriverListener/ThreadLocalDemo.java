package _WebDriverListener;

import org.testng.annotations.Test;

import _ParallelWebDriverexecutionsusingTestNG.LocalDriverManager;

public class ThreadLocalDemo {
    @Test
    public void testMethod1() {
        invokeBrowser("http://www.ndtv.com");
    }
 
    @Test
    public void testMethod2() {
        invokeBrowser("http://www.facebook.com");
 
    }
 
    private void invokeBrowser(String url) {
        System.out.println("Thread " + Thread.currentThread().getId());
        System.out.println("HashcodeebDriver instance = " + 
        LocalDriverManager.getDriver().hashCode());
        LocalDriverManager.getDriver().get(url);
    }
}