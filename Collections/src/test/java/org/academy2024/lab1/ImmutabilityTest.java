package org.academy2024.lab1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ImmutabilityTest {

    private class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    List<Person> personsImmutable = List.of(
            new Person("John", 25),
            new Person("Jane", 30),
            new Person("Doe", 35)
    );

    Person anotherPerson = new Person("Caren", 40);

    @Test
    void testListImmutability() {

        assertThatThrownBy(() -> personsImmutable.add(new Person("Jack", 40)))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> personsImmutable.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);

        assertThatThrownBy(() -> personsImmutable.set(0, anotherPerson))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testMutabilityOfListItem() {
        Person person = personsImmutable.get(0);
        person.age++;
        assertEquals(26, personsImmutable.get(0).age);
    }
}
