package _ProgrammaticinjectionofListeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class GroupsDependencyRuntimeInjector implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) {
		String []values = GroupTracker.getInstance().setDependency();
		String []groups = {values[0]};
		annotation.setGroups(groups);
		String []dependsOnGroups = {values[1]};
		dependsOnGroups[0] = values[1];
		if (!values[1].isEmpty())
			annotation.setDependsOnGroups(dependsOnGroups);
		System.out.println("Generated groupName = " + values[0]);
		System.out.println("Generated dependsOnGroupsName =" + values[1]);	
	}
}