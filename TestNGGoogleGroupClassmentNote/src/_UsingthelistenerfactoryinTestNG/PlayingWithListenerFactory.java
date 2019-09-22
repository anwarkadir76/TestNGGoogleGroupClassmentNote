package _UsingthelistenerfactoryinTestNG;

import org.testng.IExecutionListener;
import org.testng.ITestNGListener;
import org.testng.ITestNGListenerFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*

 The following points are worth keeping in mind :

 1. The class that implements ITestNGListenerFactory must be made known to TestNG only via the @Listeners annotation. 
    Using <listeners> tag in the suite file will NOT cause this listener to be invoked, 
    because this is a "Test" class listener.
 2. As per the javadocs of ITestNGListenerFactory, ONLY one instance of the object that implements ITestNGListenerFactory 
    must exist in memory.
 */


@Listeners(PlayingWithListenerFactory.class)
public class PlayingWithListenerFactory implements ITestNGListenerFactory, ITestNGListener {

	@Test
	public void foo() {
		System.out.println("Hello world foo()");
	}

	@Override
	public ITestNGListener createListener(Class<? extends ITestNGListener> listenerClass) {
		System.out.println("create listener called");
		return new MyExecutionListener();
	}

	public static class MyExecutionListener implements IExecutionListener {

		public MyExecutionListener() {
			System.out.println("Listener instantiated");
		}

		@Override
		public void onExecutionStart() {
			System.out.println("exec start");

		}

		@Override
		public void onExecutionFinish() {
			System.out.println("exec finished");

		}
	}

}