package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonUtils {

  //complexity is about O(n) + O(n).

  public static int countUsersWithSameWeightAndNotSameHeight(Person [] people) {
    Map<Integer, List<Integer>> weightsAndHeightsTable = new HashMap<>();
    for(Person person : people) {
      if (weightsAndHeightsTable.containsKey(person.getWeight())) {
        List<Integer> heights = weightsAndHeightsTable.get(person.getWeight());
        if (!heights.contains(person.getHeight())) {
          heights.add(person.getHeight());
        }
      } else {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(person.getHeight());
        weightsAndHeightsTable.put(person.getWeight(), heights);
      }
    }
    return weightsAndHeightsTable
        .entrySet().stream()
        .filter(x -> x.getValue().size() > 1)
        .mapToInt(x -> x.getValue().size())
        .sum();
  }

  public static void sortByWeight(Person [] people) {
    Arrays.sort(people, Comparator.comparingInt(Person::getWeight));
  }

  /*we can achieve linear complexity using Bucket or Radix sorting, it also makes sense to use
  counting sort, because we have defined range of values, that is small enough compared to the
  sorted set
   */
  public static void sortByAge(Person [] people) {
    Arrays.sort(people, Comparator.comparingInt(Person::getAge));
  }

  public static void sortByHeight(Person [] people) {
    Arrays.sort(people, Comparator.comparingInt(Person::getHeight));
  }
}
