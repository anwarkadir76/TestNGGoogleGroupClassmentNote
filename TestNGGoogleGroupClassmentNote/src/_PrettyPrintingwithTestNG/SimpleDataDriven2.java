package _PrettyPrintingwithTestNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class SimpleDataDriven2 { //Scenario 2: DataProvider feeds custom objects to the @Test annotated test method.
    @Test(dataProvider = "dp")
    public void myTestMethod(Person person) {
        assertNotNull(person.getName());
        assertTrue(person.getAge() != 0);
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            { new Person("John", 25) },
            { new Person("Rambo", 35) }
        };
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}