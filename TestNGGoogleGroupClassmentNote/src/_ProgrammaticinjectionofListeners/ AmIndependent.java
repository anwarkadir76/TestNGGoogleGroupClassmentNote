package _ProgrammaticinjectionofListeners;

import org.testng.annotations.Test;

@Test
public class AmIndependent {

	public void methodA() {
		System.out.println(this.getClass().getSimpleName()
				+ ".method A : Thread ID :" + Thread.currentThread().getId());

	}

	public void methodB() {
		System.out.println(this.getClass().getSimpleName()
				+ ". method B : Thread ID : " + Thread.currentThread().getId());
	}

	public void methodC() {
		System.out.println(this.getClass().getSimpleName()
				+ ". method C : Thread ID : " + Thread.currentThread().getId());
	}
}