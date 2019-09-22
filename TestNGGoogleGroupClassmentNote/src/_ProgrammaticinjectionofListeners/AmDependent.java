package _ProgrammaticinjectionofListeners;

import org.testng.annotations.Test;


@Test
public class AmDependent  {
	public void methodD() {
		System.out.println(this.getClass().getSimpleName()
				+ ".method D : Thread ID : " + Thread.currentThread().getId());
		
	}

	public void methodE() {
		System.out.println(this.getClass().getSimpleName()
				+ ".method E : Thread ID : " + Thread.currentThread().getId());
	}

	public void methodF() {
		System.out.println(this.getClass().getSimpleName()
				+ ".method F : Thread ID : " + Thread.currentThread().getId());
	}
}
