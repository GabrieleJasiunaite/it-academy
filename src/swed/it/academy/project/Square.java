package swed.it.academy.project;

import java.math.BigDecimal;

public class Square extends Shape{

    public Square(double edgeLength) {
        super(edgeLength, edgeLength);
    }
    @Override
    public void calculateArea() {
        super.rectangleArea();
    }
}
