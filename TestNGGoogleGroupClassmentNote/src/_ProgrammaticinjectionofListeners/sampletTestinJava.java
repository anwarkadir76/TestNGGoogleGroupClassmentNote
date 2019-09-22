package _ProgrammaticinjectionofListeners;

import org.testng.annotations.Test;

public static void main(String[] args) {
    TestNG testng = new TestNG();
    Class[] classes = new Class[]{IUseListeners.class};
    testng.addListener(new SeleniumStarterListener());
    testng.setTestClasses(classes);
    testng.run();
}