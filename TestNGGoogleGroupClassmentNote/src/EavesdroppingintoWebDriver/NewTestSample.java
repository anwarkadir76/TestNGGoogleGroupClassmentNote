package EavesdroppingintoWebDriver;

import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


	  private void appendListenerToWebDriver(RemoteWebDriver rwd) {
		    CommandExecutor executor = new MyFunkyExecutor(rwd.getCommandExecutor());
		    Class clazz = rwd.getClass();
		    while (! RemoteWebDriver.class.equals(clazz)) {
		    // iterate repeatedly till we get to a RemoteWebDriver reference
		        clazz = clazz.getSuperclass();
		    }
		    try {
		        //setCommandExector is the protected method within RemoteWebDriver that is
		        //responsible for accepting a command exector.
		        Method m = clazz.getDeclaredMethod("setCommandExecutor", CommandExecutor.class);
		        //This method is a protected method. So we have to make it accessible.
		        m.setAccessible(true);
		        m.invoke(rwd, executor);
		    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
		        //The above multi catch syntax will work only with JDK 1.7
		        e.printStackTrace();
		        throw new RuntimeException(e);
		    }
	  }
  } 
  }
	  