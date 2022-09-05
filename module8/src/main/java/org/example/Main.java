package org.example;

import java.util.List;
import org.example.quad.Rhombus;
import org.example.quad.Square;
import org.example.triangle.EquilateralTriangle;

public class Main {

  public static void main(String[] args) {
    List<Shape> shapes = List.of(new Square(), new Circle(), new Rhombus(),
        new EquilateralTriangle());
    ShapeNamePrinter shapeNamePrinter = new ShapeNamePrinter();
    shapes.forEach(shapeNamePrinter::print);
  }
}