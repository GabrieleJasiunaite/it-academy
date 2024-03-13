package swed.it.academy.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circle extends Shape {
    public Circle(double radius) {
        super(radius, radius);
    }
    @Override
    public void calculateArea() {
        super.rectangleArea();
        BigDecimal pi = new BigDecimal(Math.PI);
        BigDecimal circleArea = super.getShapeArea().multiply(pi);
        super.setShapeArea(circleArea.setScale(2, RoundingMode.UP));
    }
}
