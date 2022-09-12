package org.example;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Person {

  private int height;
  private int weight;
  private int age;

}
