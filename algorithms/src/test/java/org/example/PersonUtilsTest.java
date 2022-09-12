package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonUtilsTest {

  @Test
  void countUsersWithSameWeightAndNotSameHeightTest() {
    Person [] people = new Person[] {
        new Person(160, 50, 62),
        new Person(161, 50, 62),
        new Person(150, 51, 25),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
        new Person(156, 51, 20),
        new Person(162, 52, 58),
        new Person(163, 52, 96),
        new Person(151, 53, 30),
        new Person(158, 53, 48),
        new Person(159, 54, 86),
        new Person(162, 54, 54),
        new Person(150, 55, 41),
        new Person(150, 55, 53),
        new Person(164, 55, 58),
        new Person(150, 56, 34),
        new Person(152, 56, 87),
        new Person(156, 56, 74),
        new Person(157, 56, 89),
        new Person(162, 57, 45),
        new Person(160, 58, 62),
        new Person(162, 58, 97),
        new Person(151, 59, 62)
    };
    int expected = 19;
    Assertions.assertEquals(expected, PersonUtils.countUsersWithSameWeightAndNotSameHeight(people));
  }

  @Test
  void sortByWeightTest() {
    Person [] peopleInput = new Person[] {
        new Person(160, 50, 62),
        new Person(161, 50, 62),
        new Person(150, 51, 25),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
    };
    Person [] peopleExpected = new Person[] {
        new Person(150, 51, 25),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
        new Person(160, 50, 62),
        new Person(161, 50, 62),
    };
    PersonUtils.sortByHeight(peopleInput);
    Assertions.assertArrayEquals(peopleExpected, peopleInput);
  }

  @Test
  void sortByAgeTest() {
    Person [] peopleInput = new Person[] {
        new Person(160, 50, 62),
        new Person(161, 50, 62),
        new Person(150, 51, 25),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
    };
    Person [] peopleExpected = new Person[] {
        new Person(155, 51, 20),
        new Person(155, 51, 20),
        new Person(150, 51, 25),
        new Person(160, 50, 62),
        new Person(161, 50, 62),
    };
    PersonUtils.sortByAge(peopleInput);
    Assertions.assertArrayEquals(peopleExpected, peopleInput);
  }

  @Test
  void sortByHeightTest() {
    Person [] peopleInput = new Person[] {
        new Person(160, 50, 62),
        new Person(161, 50, 62),
        new Person(150, 51, 25),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
    };
    Person [] peopleExpected = new Person[] {
        new Person(150, 51, 25),
        new Person(155, 51, 20),
        new Person(155, 51, 20),
        new Person(160, 50, 62),
        new Person(161, 50, 62),
    };
    PersonUtils.sortByHeight(peopleInput);
    Assertions.assertArrayEquals(peopleExpected, peopleInput);
  }
}