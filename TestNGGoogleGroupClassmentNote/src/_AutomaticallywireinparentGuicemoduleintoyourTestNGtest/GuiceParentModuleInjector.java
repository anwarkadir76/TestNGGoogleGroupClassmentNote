package _AutomaticallywireinparentGuicemoduleintoyourTestNGtest;

import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;
 
import java.util.List;
 
public class GuiceParentModuleInjector implements IAlterSuiteListener {
    @Override
    public void alter(List suites) {
        XmlSuite suite = suites.get(0);
        suite.setParentModule(DefaultParentModule.class.getName());
    }
}