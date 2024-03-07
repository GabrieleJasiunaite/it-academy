package swed.it.academy.project;

import java.util.InputMismatchException;

public class AreaCalculator {
    public static void main(String[] args) {
        runProgram();
    }
    private static void runProgram() {
        while (IOManager.getIsRunning()){
            interactWithUser();
            outputResult();
        }
    }
    private static void interactWithUser() {
        try {
            IOManager.chooseUsersShape();
            IOManager.checkDataInput();
        } catch (InputMismatchException e) {
            System.out.println("The given input is invalid.");
        }
        catch (UnknownShapeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void outputResult() {
        Shape shape = switch (IOManager.getShapeChoice()) {
            case 1 -> {yield new Square(IOManager.getData1());}
            case 2 -> {yield new Triangle(IOManager.getData1(), IOManager.getData2());}
            case 3 -> {yield new Circle(IOManager.getData1());}
            default -> {yield null;}
        };

        if (shape != null) {
            shape.calculateArea();
            IOManager.displayArea(shape.toString());
        }

        IOManager.chooseIfContinue();
    }

}
