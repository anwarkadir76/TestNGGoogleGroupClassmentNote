package BeanShellandTestNG;

import org.testng.annotations.Test;

public class GroupsPlayGround {
    @Test(groups = "foo")
    public void foo() {
        System.out.println("foo() was invoked.");
    }
 
    @Test(groups = "bar")
    public void bar() {
        System.out.println("bar() was invoked.");
    }
 
    @Test(groups = "foobar")
    public void fooBar() {
        System.out.println("foobar() was invoked.");
    }
}