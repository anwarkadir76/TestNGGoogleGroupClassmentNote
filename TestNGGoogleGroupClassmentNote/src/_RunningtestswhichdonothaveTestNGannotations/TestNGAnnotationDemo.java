package _RunningtestswhichdonothaveTestNGannotations;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.testng.TestNG;
import org.testng.internal.PackageUtils;
 
import java.io.IOException;
import java.util.ArrayList;
 
public class TestNGAnnotationDemo {
    public static void main(String[] args)
        throws NotFoundException, 
        CannotCompileException, 
        ClassNotFoundException, IOException {
        String[] classes =
            PackageUtils.findClassesInPackage("organized.chaos.testng.legacy",
            new ArrayList<String>(), 
            new ArrayList<String>());
        Class[] clazz = TestNGAnnotationInjector.addAnnotationToTestClass(classes);
        TestNG testNG = new TestNG();
        testNG.setTestClasses(clazz);
        testNG.setVerbose(3);
        testNG.run();
    }
}