package org.example;

public class Main {

  public static void main(String[] args) {
    PersonsGenerator personsGenerator = new PersonsGenerator();
    personsGenerator.setAgeBounds(14, 100);
    personsGenerator.setHeightBounds(160, 170);
    personsGenerator.setWeightBounds(50, 70);
    Person[] users = personsGenerator.generate(20);

  }

}