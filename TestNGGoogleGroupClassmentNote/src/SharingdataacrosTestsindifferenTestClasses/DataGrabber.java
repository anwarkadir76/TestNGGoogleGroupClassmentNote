package SharingdataacrosTestsindifferenTestClasses;

import java.util.List;

import org.testng.annotations.Test;

public interface DataGrabber { //Approach 1: Via the TestClass’s instance.
    List<Integer> getSumValue();
}
