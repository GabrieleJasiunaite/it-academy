package swed.it.academy.project;

import java.math.BigDecimal;

public abstract class Shape {
    private BigDecimal shapeArea;
    private BigDecimal edgeLength1;
    private BigDecimal edgeLength2;

    public Shape(double edgeLength1, double edgeLength2) {
        this.edgeLength1 = new BigDecimal(edgeLength1);
        this.edgeLength2 = new BigDecimal(edgeLength2);
    }

    public abstract void calculateArea();

    public void rectangleArea(){

        this.shapeArea = edgeLength1.multiply(edgeLength2);
    }

    public BigDecimal getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(BigDecimal shapeArea) {
        this.shapeArea = shapeArea;
    }

    @Override
    public String toString() {
        return "The shape's area is: " + shapeArea + " cm2";
    }
}
