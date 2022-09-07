package org.example;

import java.util.List;
import org.example.quad.IsoscelesTrapezoid;
import org.example.quad.Kite;
import org.example.quad.Square;
import org.example.triangle.EquilateralTriangle;

public class Main {

  public static void main(String[] args) {
    List<Shape> shapes = List.of(
        new IsoscelesTrapezoid(),
        new Kite(),
        new Square(),
        new EquilateralTriangle(),
        new Circle()
    );
    ShapeNamePrinter shapeNamePrinter = new ShapeNamePrinter();
    shapes.forEach(shapeNamePrinter::print);
  }
}