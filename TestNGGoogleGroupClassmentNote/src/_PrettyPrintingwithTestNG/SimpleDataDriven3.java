package _PrettyPrintingwithTestNG;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class SimpleDataDriven3{ 
	//So we would need to refactor our code [especially the Person class] and add a toString() implementation to it. So the refactored test code would look like below:


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

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Person [name=")
            .append(name)
            .append(", age=")
            .append(age)
            .append("]");
            return builder.toString();
        }
    }
}