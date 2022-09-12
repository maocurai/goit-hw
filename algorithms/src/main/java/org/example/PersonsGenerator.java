package org.example;

import java.util.stream.IntStream;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PersonsGenerator {

  private int heightUpperBound = 200;
  private int heightLowerBound = 150;
  private int weightUpperBound = 120;
  private int weightLowerBound = 45;
  private int ageLowerBound = 18;
  private int ageUpperBound = 100;

  public Person[] generate(int count) {
    return IntStream.range(0, count)
        .mapToObj(
            x -> new Person(
                getRandomNumber(heightLowerBound, heightUpperBound),
                getRandomNumber(weightLowerBound, weightUpperBound),
                getRandomNumber(ageLowerBound, ageUpperBound)
            ))
        .toArray(Person[]::new);
  }

  private int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  public void setAgeBounds(int lowerBound, int upperBound) {
    setAgeLowerBound(lowerBound);
    setAgeUpperBound(upperBound);
  }

  public void setHeightBounds(int lowerBound, int upperBound) {
    setHeightLowerBound(lowerBound);
    setHeightUpperBound(upperBound);
  }

  public void setWeightBounds(int lowerBound, int upperBound) {
    setWeightLowerBound(lowerBound);
    setWeightUpperBound(upperBound);
  }

}
