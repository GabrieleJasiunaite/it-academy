package swed.it.academy.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends Shape{
    public Triangle(double edgeLength1, double edgeLength2) {
        super(edgeLength1, edgeLength2);
    }
    @Override
    public void calculateArea() {
        super.rectangleArea();
        BigDecimal triangleArea = super.getShapeArea().divide(BigDecimal.TWO, RoundingMode.UP);
        super.setShapeArea(triangleArea);
    }
}
